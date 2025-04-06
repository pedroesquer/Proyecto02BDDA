package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public interface IProductosDAO {
    public abstract Producto registrar(NuevoProductoDTO nuevoProductoDTO);
    
    public abstract List<Producto> consultar(String filtroBusqueda);
    
    public abstract Producto actualizarProducto(ActualizarProductoDTO actualizarProductoDTO) throws PersistenciaException;
    
    public abstract Boolean existeProductoConNombre(String nombre);
    
    public abstract Producto consultarProductoIndividual(Long idProducto);
}
