package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoComandaDTO;
import itson.sistemarestaurantedominio.dtos.AgregarProductoComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoComandaDTO;
import itson.sistemarestaurantepersistencia.IProductosComanda;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
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

    /**
     * Método que agrega un producto a una comanda ya existente, ya que cuando la comanda se crea ya se crea con productos.
     * @param agregarProductoComandaDTO 
     * @return  el Producto agregado a la comanda ya existente.
     * @throws itson.sistemarestaurantepersistencia.excepciones.PersistenciaException 
     */
    @Override
    public ProductoComanda registrar(AgregarProductoComandaDTO agregarProductoComandaDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        Comanda comanda = entityManager.find(Comanda.class, agregarProductoComandaDTO.getIdComanda());
        Producto producto = entityManager.find(Producto.class, agregarProductoComandaDTO.getIdProducto());
        
        if (comanda == null || producto == null) {
            throw new PersistenciaException("Comanda o Producto no encontrados.");
        }
        ProductoComanda relacion = new ProductoComanda(
                agregarProductoComandaDTO.getComentario(), 
                agregarProductoComandaDTO.getPrecioUnitario(), 
                agregarProductoComandaDTO.getCantidad(), 
                comanda, 
                producto);
                
        entityManager.persist(relacion);
        entityManager.getTransaction().commit();
        return relacion;
    }

  
    
}
