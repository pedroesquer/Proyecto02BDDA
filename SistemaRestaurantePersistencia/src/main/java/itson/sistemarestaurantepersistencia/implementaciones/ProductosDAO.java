package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
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

    @Override
    public Producto actualizarProducto(ActualizarProductoDTO actualizarProductoDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();

        //Buscamos un producto
        Producto producto = entityManager.find(Producto.class, actualizarProductoDTO.getId());
        
        if(producto != null){
            //Actualizamos los campos con el DTO
            producto.setNombre(actualizarProductoDTO.getNombre());
            producto.setPrecio(actualizarProductoDTO.getPrecio());
        } else{
            throw new PersistenciaException("El producto no existe");
        }
        

        entityManager.merge(producto);
        entityManager.getTransaction().commit();
        return producto;
            
        
    }
    
     /**
     * Método que hace una consulta a la base de datos y regresa un true si encuentra coincidencias con el nombre enviado.
     * @param nombre El nombre del producto que se intenta registrar.
     * @return True si encuentra coincidencias, falso si no.
     */
    @Override
    public Boolean existeProductoConNombre(String nombre) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();

        String jpql = "SELECT COUNT(p) FROM Producto p WHERE p.nombre = :nombre";
        Long count = entityManager.createQuery(jpql, Long.class)
                .setParameter("nombre", nombre)
                .getSingleResult();

        return count > 0;
    }

    @Override
    public Producto consultarProductoIndividual(Long idProducto) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        return entityManager.find(Producto.class, idProducto);
    }
    
}
