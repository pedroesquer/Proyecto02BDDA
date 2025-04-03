package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;

/**
 *
 * @author juanpheras
 */
public interface IProductosDAO {
    public abstract Producto registrar(NuevoProductoDTO nuevoProductoDTO);
}
