package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoComandaDTO;
import itson.sistemarestaurantepersistencia.IProductosComanda;
import javax.persistence.EntityManager;

/**
 *
 * @author pedro
 */
public class ProductosComandaDAO implements IProductosComanda{

    @Override
    public ProductoComanda actualizarCantidad(ActualizarProductoComandaDTO actualizarProductoComandaDTO) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        ProductoComanda productoComanda = entityManager.find(ProductoComanda.class, actualizarProductoComandaDTO.getIdProductoComanda());
        if(productoComanda != null) {
            productoComanda.setCantidad(actualizarProductoComandaDTO.getCantidad());
        }
        productoComanda.setImporte(actualizarProductoComandaDTO.getCantidad() * productoComanda.getPrecioUnitario());
        entityManager.merge(productoComanda);
        entityManager.getTransaction().commit();
        return productoComanda;
    }

    @Override
    public void registrar(NuevoProductoComandaDTO nuevoProductoComandaDTO) {
    }

  
    
}
