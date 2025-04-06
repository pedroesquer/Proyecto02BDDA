package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.ActualizarStockIngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public interface IIngredientesBO {
    public abstract Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException;
    
    public abstract List<Ingrediente> consultar(String filtroBusqueda) throws NegocioException;
    
    public abstract Ingrediente actualizar(ActualizarStockIngredienteDTO ingredienteActualizado) throws NegocioException;
}
