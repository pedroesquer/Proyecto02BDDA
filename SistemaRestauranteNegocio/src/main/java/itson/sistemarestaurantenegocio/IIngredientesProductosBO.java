
package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.IngredienteProducto;
import itson.sistemarestaurantedominio.dtos.ActualizarIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.DetalleIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevaRelacionIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public interface IIngredientesProductosBO {
    
    public abstract List<DetalleIngredienteProductoDTO> consultarIngredientesProducto(Long idProducto) throws NegocioException;
    
    public abstract IngredienteProducto registrarRelacion(NuevaRelacionIngredienteProductoDTO relacionIngredienteProductoDTO) throws NegocioException, PersistenciaException;
    
    public abstract IngredienteProducto actualizar(ActualizarIngredienteProductoDTO actualizarIngredienteProducto) throws NegocioException, PersistenciaException;
}
