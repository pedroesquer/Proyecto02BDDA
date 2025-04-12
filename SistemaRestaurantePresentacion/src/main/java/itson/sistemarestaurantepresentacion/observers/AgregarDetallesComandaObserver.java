
package itson.sistemarestaurantepresentacion.observers;

import itson.sistemarestaurantedominio.dtos.AgregarProductoComandaDTO;

/**
 *
 * @author pedro
 */
public interface AgregarDetallesComandaObserver {

    void detallesProductoComandaAceptado(AgregarProductoComandaDTO productoComandaDTO);
}
