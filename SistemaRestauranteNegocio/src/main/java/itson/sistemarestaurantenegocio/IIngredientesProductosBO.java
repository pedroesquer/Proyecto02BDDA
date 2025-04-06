
package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.dtos.DetalleIngredienteProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public interface IIngredientesProductosBO {
    
    public abstract List<DetalleIngredienteProductoDTO> consultarIngredientesProducto(Long idProducto) throws NegocioException;
    
}
