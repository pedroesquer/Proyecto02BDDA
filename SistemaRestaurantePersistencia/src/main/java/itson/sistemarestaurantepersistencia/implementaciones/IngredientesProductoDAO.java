/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredienteProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.ActualizarIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.DetalleIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevaRelacionIngredienteProductoDTO;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author juanpheras
 */
public class IngredientesProductoDAO implements IIngredientesProductosDAO  {

    /**
     * Método registrar que en caso de que exista la relación, solo actualiza la cantidad.
     * @param relacionIngredienteProductoDTO la relacion ingredienteProducto
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public IngredienteProducto registrar(NuevaRelacionIngredienteProductoDTO relacionIngredienteProductoDTO) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        
        IngredienteProducto relacion = new IngredienteProducto();
        
        Producto producto = entityManager.find(Producto.class, relacionIngredienteProductoDTO.getIdProducto());
        
        if(producto == null){
            //Logica para las excepciones
            throw new PersistenciaException("El producto no existe");
        }
        
        relacion.setProducto(producto);
        
        Ingrediente ingrediente = entityManager.find(Ingrediente.class, relacionIngredienteProductoDTO.getIdIngrediente());
        
        if(ingrediente == null){
            //Logica para las excepciones
            throw new PersistenciaException("El ingrediente no existe");

        }
        // Buscar si ya existe una relación entre este producto y este ingrediente
    IngredienteProducto relacionExistente = entityManager.createQuery(
            "SELECT ip FROM IngredienteProducto ip WHERE ip.producto = :producto AND ip.ingrediente = :ingrediente", 
            IngredienteProducto.class)
            .setParameter("producto", producto)
            .setParameter("ingrediente", ingrediente)
            .getResultStream()
            .findFirst()
            .orElse(null);

    // Si existe la relación, sumamos la cantidad
    if (relacionExistente != null) {
        relacionExistente.setCantidad(relacionExistente.getCantidad() + relacionIngredienteProductoDTO.getCantidad());
        entityManager.merge(relacionExistente);  // Actualiza el registro
        entityManager.getTransaction().commit();
        return relacionExistente;
    } else {
        // Si no existe la relación, creamos una nueva
        IngredienteProducto nuevaRelacion = new IngredienteProducto();
        nuevaRelacion.setProducto(producto);
        nuevaRelacion.setIngrediente(ingrediente);
        nuevaRelacion.setCantidad(relacionIngredienteProductoDTO.getCantidad());
        entityManager.persist(nuevaRelacion);  // Inserta un nuevo registro
        entityManager.getTransaction().commit();
        return nuevaRelacion;
    }
    
    
    
      // Devolver la relación actualizada o nueva
}
    

    /**
     * Método que actualiza la cantidad de la relación ingredienteProducto.
     * @param actualizarIngredienteProducto
     * @return
     * @throws PersistenciaException 
     */
    @Override
    public IngredienteProducto actualizar(ActualizarIngredienteProductoDTO actualizarIngredienteProducto) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        
        IngredienteProducto ingredienteProducto = entityManager.find(IngredienteProducto.class, 
                actualizarIngredienteProducto.getId());
        
        if(ingredienteProducto != null){
            ingredienteProducto.setCantidad(actualizarIngredienteProducto.getCantidad());
        } else {
            throw new PersistenciaException("No se encontró una relación ");
        }
        
        entityManager.merge(ingredienteProducto);
        entityManager.getTransaction().commit();
        return ingredienteProducto;
        
        
    }

    /**
     * Método que consulta los ingredientes de un producto.
     * @param idProducto id del producto a consultar ingredientes.
     * @return 
     */
    @Override
    public List<DetalleIngredienteProductoDTO> consultarIngredientesProducto(Long idProducto) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        String jpqlQuery = """
                SELECT new itson.sistemarestaurantedominio.dtos.DetalleIngredienteProductoDTO(
                           IP.id, IP.cantidad, I.unidadMedida, I.nombre
            )
            FROM IngredienteProducto IP
            JOIN IP.producto  P                         
            JOIN IP.ingrediente i
            WHERE P.id = :idProducto              
        """;
        
        TypedQuery<DetalleIngredienteProductoDTO> query = entityManager.createQuery(jpqlQuery, 
                DetalleIngredienteProductoDTO.class);
        query.setParameter("idProducto", idProducto);
        
        return query.getResultList();
    }
    
    
}
