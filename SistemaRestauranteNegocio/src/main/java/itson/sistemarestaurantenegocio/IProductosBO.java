
package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public interface IProductosBO {
    
    public abstract Producto registrar(NuevoProductoDTO nuevoProducto) throws NegocioException;
    
    public abstract List<Producto> consultar(String filtroBusqueda) throws NegocioException;
    
    public abstract Producto actualizar(ActualizarProductoDTO actualizarProducto) throws NegocioException, PersistenciaException;
    
}
