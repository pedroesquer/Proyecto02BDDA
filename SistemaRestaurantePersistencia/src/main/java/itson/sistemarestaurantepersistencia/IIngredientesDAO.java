package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.UnidadMedida;
import itson.sistemarestaurantedominio.dtos.ActualizarStockIngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public interface IIngredientesDAO {

    public abstract Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente);
    
    public abstract void eliminar(Long idIngrediente);
    
    public abstract Ingrediente agregarStock(ActualizarStockIngredienteDTO ingredienteActualizado);

    public abstract List<Ingrediente> consultarIngredientes(String filtroBusqueda);

    public abstract List<Ingrediente> consultarIngredientesNombre(String nombre);

    public abstract List<Ingrediente> consultarIngredientesUnidad(UnidadMedida unidadMedida);
    
    public abstract Ingrediente consultarIngredientePorNombreYUnidad(String nombre, UnidadMedida unidadMedida);

}
