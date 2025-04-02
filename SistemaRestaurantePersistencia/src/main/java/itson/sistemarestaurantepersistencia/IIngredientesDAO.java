
package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer
 */
public interface IIngredientesDAO {
    public abstract Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente);
    public abstract List<Ingrediente> consultarIngredientes();
}
