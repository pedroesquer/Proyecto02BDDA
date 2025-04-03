package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author juanpheras
 */
public class ProductosDAO implements IProductosDAO{

    @Override
    public Producto registrar(NuevoProductoDTO nuevoProducto ) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        
        Producto producto =  new Producto(nuevoProducto.getNombre(), 
                nuevoProducto.getPrecio(), 
                nuevoProducto.getTipo());
        
        entityManager.persist(producto);
        entityManager.getTransaction().commit();
        return producto;
    }
    
    
}
