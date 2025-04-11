package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.EstadoComanda;
import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

        // Calcular el inicio y el fin del día
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

}
