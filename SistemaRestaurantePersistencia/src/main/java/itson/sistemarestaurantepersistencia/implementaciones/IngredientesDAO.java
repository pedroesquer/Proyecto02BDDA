package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.UnidadMedida;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author pedro
 */
public class IngredientesDAO implements IIngredientesDAO{

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
    
    
}
