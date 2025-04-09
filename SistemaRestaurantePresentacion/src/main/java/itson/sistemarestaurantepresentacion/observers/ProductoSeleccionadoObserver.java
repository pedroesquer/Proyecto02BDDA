package itson.sistemarestaurantepresentacion.observers;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;

/**
 *
 * @author Juan Heras,
 */
public interface ProductoSeleccionadoObserver {
    
    void productoSeleccionado(NuevoProductoDTO producto);
}
