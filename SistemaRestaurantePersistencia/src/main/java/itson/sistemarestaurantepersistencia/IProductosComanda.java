package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoComandaDTO;

/**
 *
 * @author pedro
 */
public interface IProductosComanda {
    public abstract void registrar(NuevoProductoComandaDTO nuevoProductoComandaDTO);
    public abstract ProductoComanda actualizarCantidad(ActualizarProductoComandaDTO actualizarProductoComandaDTO);
}
