package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.EstadoComanda;
import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredienteProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.excepciones.CantidadInexistenteException;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author pedro
 */
public class ComandasDAO implements IComandasDAO {

    @Override
    public Comanda registrar(NuevaComandaDTO nuevaComanda) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Comanda comanda = new Comanda();
        comanda.setEstado(EstadoComanda.ABIERTA);
        comanda.setFechaHora(LocalDateTime.now());
        comanda.setMesa(nuevaComanda.getMesa());
        comanda.setFolio(obtenerFolioDelDia());
        comanda.setMontoTotal(0.0);

        if (!(nuevaComanda.getCliente() == null)) {
            comanda.setCliente(nuevaComanda.getCliente());
        }

        if (nuevaComanda.getProductoComanda().isEmpty() || nuevaComanda.getProductoComanda() == null) {
            throw new PersistenciaException("No puedes añadir una comanda sin productos.");
        }

        //Para cada producto de la relación intermedia lo vinculamos con la comanda a registrar
        List<ProductoComanda> productosComanda = nuevaComanda.getProductoComanda();
        comanda.setProductos(nuevaComanda.getProductoComanda());

        productosComanda.forEach(productoComanda -> productoComanda.setComanda(comanda));

        entityManager.persist(comanda);

        entityManager.getTransaction().commit();
        return comanda;
    }

    public String obtenerFolioDelDia() {
        EntityManager em = ManejadorConexiones.getEntityManager();

        // Obtener la fecha actual en formato yyyyMMdd
        LocalDate hoy = LocalDate.now();
        String fechaFormato = hoy.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        LocalDateTime inicioDelDia = hoy.atStartOfDay();
        LocalDateTime finDelDia = hoy.atTime(LocalTime.MAX);

        // Contar el número de registros para la fecha actual
        TypedQuery<Long> query = em.createQuery("""
        SELECT COUNT(c) FROM Comanda c
        WHERE c.fechaHora BETWEEN :inicio AND :fin
    """, Long.class);

        query.setParameter("inicio", inicioDelDia);
        query.setParameter("fin", finDelDia);

        Long total = query.getSingleResult();

        // Formato de folio: "OB" + yyyymmdd + xxx
        String folio = "OB" + fechaFormato + String.format("%03d", total.intValue() + 1);

        return folio;
    }

    /**
     * Método que cambia el estado de una comanda a cerrada, pero primero
     * verificando que se puedan hacer todos sus prodcutos con el stock de
     * ingredientes requerido.
     *
     * @param idComanda Id de la comanda para actualizar y obtener los productos
     * que se prepararán.
     * @return La comanda con el estado Cerrada.
     * @throws
     * itson.sistemarestaurantepersistencia.excepciones.PersistenciaException
     * @throws CantidadInexistenteException
     */
    @Override
    public Comanda cerrarComanda(Long idComanda) throws PersistenciaException, CantidadInexistenteException {
        EntityManager em = ManejadorConexiones.getEntityManager();
        em.getTransaction().begin();
        Comanda comanda = em.find(Comanda.class, idComanda);

        if (comanda == null) {
            throw new PersistenciaException("La comanda no existe");
        }

        //Aqui tenemos que crear un mapa para que se vayan añadiendo o actualzando los ingrediente requerido para la comanda
        Map<Ingrediente, Integer> ingredientesRequeridosProductos = new HashMap<>();

        for (ProductoComanda productoComanda : comanda.getProductos()) {
            Producto producto = productoComanda.getProducto(); //Obtenemos el producto de la comanda 
            for (IngredienteProducto ingredienteProducto : producto.getIngredientes()) {
                Ingrediente ingrediente = ingredienteProducto.getIngrediente();

                //Se obtiene la cantidad de ingrediente requerida para el producto especifico de la iteración 
                //Y lo multiplicamos por la cantidad de productos iguales que sean en esa comanda
                Integer cantidadTotal = productoComanda.getCantidad() * ingredienteProducto.getCantidad();

                //Ahora actualizamos las relaciones sumando cantida o añadimos el ingredietne dependiendo si no esta.
                ingredientesRequeridosProductos.merge(ingrediente, cantidadTotal, Integer::sum);
            }
        }

        //Una vez que ya tenemos la cantidad de ingredientes requeridos para la comanda, pasamos a verificar si hay stock para el ingrediente
        for (Map.Entry<Ingrediente, Integer> entry : ingredientesRequeridosProductos.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            int requerido = entry.getValue();

            if (ingrediente.getStock() < requerido) {
                throw new CantidadInexistenteException("Stock insuficiente para " + ingrediente.getNombre());
            }
        }

        //Ahora descontamos el stock de cada ingrediente
        for (Map.Entry<Ingrediente, Integer> entry : ingredientesRequeridosProductos.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            int requerido = entry.getValue();
            ingrediente.setStock(ingrediente.getStock() - requerido);
            em.merge(ingrediente);
        }

        //Si en todos los ingredientes cumplieron con lo del stock se cambia el estado de la comanda a CERRADA
        comanda.setEstado(EstadoComanda.CERRADA);
        em.merge(comanda);

        em.getTransaction().commit();

        return comanda;
    }

    @Override
    public Comanda cancelarComanda(Long idComanda) throws PersistenciaException {

        EntityManager em = ManejadorConexiones.getEntityManager();
        em.getTransaction().begin();

        // Buscar la comanda
        Comanda comanda = em.find(Comanda.class, idComanda);

        // Validar existencia
        if (comanda == null) {
            em.getTransaction().rollback();
            throw new PersistenciaException("La comanda no existe");
        }

        // Validar que esté abierta
        if (!comanda.getEstado().equals(EstadoComanda.ABIERTA)) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Solo se pueden cancelar comandas en estado ABIERTA");
        }

        // Cambiar estado a CANCELADA
        comanda.setEstado(EstadoComanda.CANCELADA);
        em.merge(comanda);

        em.getTransaction().commit();
        return comanda;
    }

    @Override
    public List<Comanda> consultarComanda() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Comanda> criteriaQuery = criteriaBuilder.createQuery(Comanda.class);
        Root<Comanda> root = criteriaQuery.from(Comanda.class);

        // Condición para que el estado sea igual a "abierto"
        // Asegúrate de que al comparar, estés usando el Enum en vez de un String
        Predicate condicionEstadoAbierto = criteriaBuilder.equal(root.get("estado"), EstadoComanda.ABIERTA);

        // Aplicamos la condición al WHERE
        criteriaQuery.where(condicionEstadoAbierto);

        TypedQuery<Comanda> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Comanda consultarComandaIndividual(Long idComanda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        return entityManager.find(Comanda.class, idComanda);
    }

    /**
     * Método para buscar comandas dentro de una fechas especificas.
     * @param desde
     * @param hasta
     * @return 
     */
    public List<Comanda> buscarPorRangoFechas(Date desde, Date hasta) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        // Convertimos Date a LocalDateTime
        LocalDateTime fechaDesde = desde.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDateTime fechaHasta = hasta.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        String jpql = "SELECT c FROM Comanda c WHERE c.fechaHora BETWEEN :desde AND :hasta";
        return entityManager.createQuery(jpql, Comanda.class)
                .setParameter("desde", fechaDesde)
                .setParameter("hasta", fechaHasta)
                .getResultList();
    }
}
