package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.UnidadMedida;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer
 */
public interface IIngredientesDAO {

    public abstract Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente);
    
    public abstract void eliminar(Long idIngrediente);

    public abstract List<Ingrediente> consultarIngredientes();

    public abstract List<Ingrediente> consultarIngredientesNombre(String nombre);

    public abstract List<Ingrediente> consultarIngredientesUnidad(UnidadMedida unidadMedida);

}
