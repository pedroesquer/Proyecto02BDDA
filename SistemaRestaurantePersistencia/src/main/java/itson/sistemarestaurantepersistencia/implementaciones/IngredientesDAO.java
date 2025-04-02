package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.UnidadMedida;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author pedro
 */
public class IngredientesDAO implements IIngredientesDAO {

    /**
     * Registra un nuevo ingrediente en la base de datos.
     *
     * @param nuevoIngrediente Objeto DTO que contiene los datos de un nuevo
     * ingrediente.
     * @return Objeto recién creado y persistido en la base de datos.
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
     * Consulta que regresa la lista de ingredientes que tenemos en la base de datos.
     *

     * @return Lista de ingredientes.
     */
    @Override
    public List<Ingrediente> consultarIngredientes() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> cq = cb.createQuery(Ingrediente.class);
        Root<Ingrediente> root = cq.from(Ingrediente.class);
        List<Ingrediente> ingredientes = entityManager.createQuery(cq).getResultList();
        return ingredientes;

    }

}
