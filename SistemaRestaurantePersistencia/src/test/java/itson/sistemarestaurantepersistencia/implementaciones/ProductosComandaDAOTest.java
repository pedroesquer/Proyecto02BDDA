/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoComandaDTO;
import itson.sistemarestaurantedominio.dtos.AgregarProductoComandaDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pedro
 */
public class ProductosComandaDAOTest {
    
    public ProductosComandaDAOTest() {
    }

    /**
     * Test of actualizarCantidad method, of class ProductosComandaDAO.
     */
    @Test
    public void testActualizarCantidad() {
        ProductosComandaDAO productosComandaDAO = new ProductosComandaDAO();
        ActualizarProductoComandaDTO productoComandaDTO = new ActualizarProductoComandaDTO();
        productoComandaDTO.setIdProductoComanda(1L);
        productoComandaDTO.setCantidad(3);
        
        ProductoComanda productoComanda = productosComandaDAO.actualizarCantidad(productoComandaDTO);
        assertEquals(productoComandaDTO.getCantidad(), productoComanda.getCantidad());
        
    }

    /**
     * Test of registrar method, of class ProductosComandaDAO.
     */
    @Test
    public void testRegistrarNuevoProductoOk() throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        
        ProductosComandaDAO productosComandaDAO = new ProductosComandaDAO();
        AgregarProductoComandaDTO productoComandaDTO = new AgregarProductoComandaDTO();
        
        Producto producto = entityManager.find(Producto.class, 2l);
        productoComandaDTO.setIdComanda(5L);
        productoComandaDTO.setIdProducto(2L);
        
        productoComandaDTO.setCantidad(3);
        productoComandaDTO.setComentario("Sin alga los 3");
        productoComandaDTO.setPrecioUnitario(producto.getPrecio());
        productoComandaDTO.setImporte(productoComandaDTO.getPrecioUnitario()*productoComandaDTO.getCantidad());
        
        ProductoComanda productoComanda = productosComandaDAO.registrar(productoComandaDTO);
        
        assertNotNull(productoComanda.getId());
        
        
        
        
    }
    
}
