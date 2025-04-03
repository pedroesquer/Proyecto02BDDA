/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredienteProducto;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.ActualizarIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevaRelacionIngredienteProductoDTO;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import javax.persistence.EntityManager;

/**
 *
 * @author juanpheras
 */
public class IngredientesProductoDAO implements IIngredientesProductosDAO  {

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
        relacion.setIngrediente(ingrediente);
        
        relacion.setCantidad(relacionIngredienteProductoDTO.getCantidad());
        
        entityManager.persist(relacion);
        entityManager.getTransaction().commit();
        
        return relacion;
    }

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
    
}
