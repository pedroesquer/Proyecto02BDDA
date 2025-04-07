package itson.sistemarestaurantepresentacion.observers;

import itson.sistemarestaurantedominio.Producto;

/**
 *
 * @author Juan Heras,
 */
public interface ProductoSeleccionadoObserver {
    
    void productoSeleccionado(Producto producto);
}
