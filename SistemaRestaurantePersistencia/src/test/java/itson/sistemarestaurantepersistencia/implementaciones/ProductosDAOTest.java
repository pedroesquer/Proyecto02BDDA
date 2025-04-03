/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author juanpheras
 */
public class ProductosDAOTest {
    
    public ProductosDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
        
    }

    /**
     * Test of registrar method, of class ProductosDAO.
     */
    @Test
    public void testRegistrarProductoOK() {
        //Primero creamos la DAO de producto
        ProductosDAO productosDAO = new ProductosDAO();
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO("Nachos con carne", 90f, TipoProducto.PLATILLO);
        
        Producto producto = productosDAO.registrar(nuevoProducto);
        
        assertNotNull(producto.getId());
        
        assertEquals(nuevoProducto.getNombre(), producto.getNombre());
        assertEquals(nuevoProducto.getPrecio(), producto.getPrecio());
        assertEquals(nuevoProducto.getTipo(), producto.getTipo());
    }
    
}
