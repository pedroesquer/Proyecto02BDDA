
package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;

/**
 *
 * @author Pedro Morales Esquer
 */
public interface IIngredientesDAO {
    public abstract Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente);
}
