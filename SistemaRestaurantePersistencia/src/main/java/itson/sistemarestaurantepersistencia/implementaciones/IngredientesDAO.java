package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.UnidadMedida;
import itson.sistemarestaurantedominio.dtos.ActualizarStockIngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Morales Esquer
 */
public class IngredientesDAO implements IIngredientesDAO {

    /**
     * Registra un nuevo ingrediente en la base de datos.
     *
     * @param nuevoIngrediente Objeto DTO que contiene los datos de un nuevo
     * ingrediente.
     * @return Objeto ingrediente recién creado y persistido en la base de
     * datos.
     */
    @Override
    public Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();


        Ingrediente ingrediente = new Ingrediente(nuevoIngrediente.getNombre(),
                nuevoIngrediente.getStock(), nuevoIngrediente.getUnidadMedida());
        entityManager.persist(ingrediente);
        entityManager.getTransaction().commit();
        return ingrediente;
    }

    /**
     * Actualiza el stock de un ingrediente en la base de datos.
     *
     * @param ingredienteActualizado Objeto DTO que contiene la cantidad (stock)
     * de un ingrediente
     * @return Objeto ingrediente con stock actualizado.
     */
    @Override
    public Ingrediente agregarStock(ActualizarStockIngredienteDTO ingredienteActualizado) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Ingrediente ingrediente = entityManager.find(Ingrediente.class, ingredienteActualizado.getId());
        if (ingrediente != null) {
            ingrediente.setStock(ingredienteActualizado.getStock());
        }
        entityManager.merge(ingrediente);
        entityManager.getTransaction().commit();
        return ingrediente;
    }

    /**
     * Registra un nuevo ingrediente en la base de datos.
     *
     * @param idIngrediente Id del ingrediente el cual se deseé borrar
     *
     */
    @Override
    public void eliminar(Long idIngrediente) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Ingrediente ingrediente = entityManager.find(Ingrediente.class, idIngrediente);
        if (ingrediente != null) {
            entityManager.remove(ingrediente);
        }
        entityManager.getTransaction().commit();

    }

    /**
     * Consulta que regresa la lista de ingredientes que tenemos en la base de
     * datos.
     *
     *
     * @param filtroBusqueda
     * @return Lista de ingredientes.
     */
    @Override
    public List<Ingrediente> consultarIngredientes(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Ingrediente> criteriaQuery = criteriaBuilder.createQuery(Ingrediente.class);
        Root<Ingrediente> root = criteriaQuery.from(Ingrediente.class);

        //Primero creamos dos predicados, ya que queremos hacer un OR necesitamos primero separarlo
        Predicate condicionNombre = criteriaBuilder.like(root.get("nombre"), "%" + filtroBusqueda + "%");
        Predicate condicionUnidadMedida = criteriaBuilder.like(root.get("unidadMedida"), "%" + filtroBusqueda + "%");

        //Ahora combinamos las condiciones con un "or"
        Predicate condicion = criteriaBuilder.or(condicionNombre, condicionUnidadMedida);

        //Asignamos la condición ya combinada al where
        criteriaQuery.where(condicion);
        TypedQuery<Ingrediente> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();

    }

    /**
     * Consulta que regresa la lista de ingredientes que tenemos en la base de
     * datos filtrando por nombre.
     *
     * @param nombre El nombre del ingrediente que se deseé buscar
     * @return Lista de ingredientes filtrada.
     */
    @Override
    public List<Ingrediente> consultarIngredientesNombre(String nombre) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> cq = cb.createQuery(Ingrediente.class);
        Root<Ingrediente> root = cq.from(Ingrediente.class);
        cq.select(root).where(cb.equal(root.get("nombre"), nombre));
        List<Ingrediente> ingredientes = entityManager.createQuery(cq).getResultList();
        return ingredientes;
    }

    /**
     * Consulta que regresa la lista de ingredientes que tenemos en la base de
     * datos filtrando por unidad de medida .
     *
     * @param unidadMedida Unidad de medida por la que se desee filtrar
     * @return Lista de ingredientes filtrada.
     */
    @Override
    public List<Ingrediente> consultarIngredientesUnidad(UnidadMedida unidadMedida) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> cq = cb.createQuery(Ingrediente.class);
        Root<Ingrediente> root = cq.from(Ingrediente.class);
        cq.select(root).where(cb.equal(root.get("unidadMedida"), unidadMedida));
        List<Ingrediente> ingredientes = entityManager.createQuery(cq).getResultList();
        return ingredientes;
    }

    /**
     * Consulta que regresa si existe un ingrediente con el nombre y la unidad igual al que se quiere registrar.
     * @param nombre Nombre del producto que se quiere consultar
     * @param unidadMedida Unidad de medida del producto que se quiere consultar.
     * @return Si la lista está vacía regresa null, si la lista viene con algo regresa el ingrediente.
    */
    @Override
    public Ingrediente consultarIngredientePorNombreYUnidad(String nombre, UnidadMedida unidadMedida) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> criteriaQuery = criteriaBuilder.createQuery(Ingrediente.class);
        Root<Ingrediente> root = criteriaQuery.from(Ingrediente.class);

        Predicate nombreCondicion = criteriaBuilder.equal(root.get("nombre"), nombre);
        Predicate unidadCondicion = criteriaBuilder.equal(root.get("unidadMedida"), unidadMedida);

        criteriaQuery.where(criteriaBuilder.and(nombreCondicion, unidadCondicion));
        TypedQuery<Ingrediente> query = entityManager.createQuery(criteriaQuery);

        List<Ingrediente> ingredientes = query.getResultList();

        if (ingredientes.isEmpty()) {
            return null; 
        } else {
            return ingredientes.get(0); 
        }
    }

}
