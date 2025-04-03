package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    @Override
    public List<Producto> consultar(String filtroBusqueda) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Producto> criteriaQuery = criteriaBuilder.createQuery(Producto.class);
        Root<Producto> root = criteriaQuery.from(Producto.class); 
        
        //Primero creamos dos predicados, ya que queremos hacer un OR necesitamos primero separarlo
        Predicate condicionNombre = criteriaBuilder.like(root.get("nombre"), "%"+filtroBusqueda+"%");
        Predicate condicionTipo = criteriaBuilder.like(root.get("tipo"), "%"+ filtroBusqueda +"%");
        
        //Ahora combinamos las condiciones con un "or"
        Predicate condicion = criteriaBuilder.or(condicionNombre, condicionTipo);
        
        //Asignamos la condición ya combinada al where
        criteriaQuery.where(condicion);
        TypedQuery<Producto> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
        
        
        
        
        
    }
    
    
    
}
