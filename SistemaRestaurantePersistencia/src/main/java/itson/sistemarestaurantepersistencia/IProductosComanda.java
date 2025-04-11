package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoComandaDTO;
import itson.sistemarestaurantedominio.dtos.AgregarProductoComandaDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;

/**
 *
 * @author pedro
 */
public interface IProductosComanda {
    public abstract ProductoComanda registrar(AgregarProductoComandaDTO agregarProductoComandaDTO) throws PersistenciaException;
    public abstract ProductoComanda actualizarCantidad(ActualizarProductoComandaDTO actualizarProductoComandaDTO);
}
