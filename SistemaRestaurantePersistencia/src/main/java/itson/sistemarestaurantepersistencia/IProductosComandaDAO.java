package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoComandaDTO;
import itson.sistemarestaurantedominio.dtos.AgregarProductoComandaDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface IProductosComandaDAO {
    public abstract ProductoComanda registrar(AgregarProductoComandaDTO agregarProductoComandaDTO) throws PersistenciaException;
    public abstract ProductoComanda actualizarCantidad(ActualizarProductoComandaDTO actualizarProductoComandaDTO);
    public abstract List<ProductoComanda> consultar(Long idComanda);
}