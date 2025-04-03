/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import java.util.List;
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
    
    final int resultadoFiltroBusquedaBebida = 2;
    final int resultadoFiltroBusquedaPlatillo = 4;
    final int resultadoFiltroBusquedaPostre = 1;
    final String filtroBusqueda = "carne";
    
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
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO("Sopa", 30f, TipoProducto.PLATILLO);
        
        Producto producto = productosDAO.registrar(nuevoProducto);
        
        assertNotNull(producto.getId());
        
        assertEquals(nuevoProducto.getNombre(), producto.getNombre());
        assertEquals(nuevoProducto.getPrecio(), producto.getPrecio());
        assertEquals(nuevoProducto.getTipo(), producto.getTipo());
    }
    
    
    @Test
    public void testConsultarFiltroBusquedaBebida(){
        ProductosDAO productosDAO = new ProductosDAO();
        
        List<Producto> productos = productosDAO.consultar("bebida");
        
        assertNotNull(productos);
        assertEquals(resultadoFiltroBusquedaBebida, productos.size());
    }
    
    @Test
    public void testConsultarFiltroBusquedaPlatillo(){
        ProductosDAO productosDAO = new ProductosDAO();
        
        List<Producto> productos = productosDAO.consultar("platillo");
        
        assertNotNull(productos);
        assertEquals(resultadoFiltroBusquedaPlatillo, productos.size());
    }
    
    @Test
    public void testConsultarFiltroBusquedaPostre(){
        ProductosDAO productosDAO = new ProductosDAO();
        
        List<Producto> productos = productosDAO.consultar("postre");
        
        assertNotNull(productos);
        assertEquals(resultadoFiltroBusquedaPostre, productos.size());
    }
    
    
    @Test
    public void testConsultarFiltroBusquedaPalabra(){
        ProductosDAO productosDAO = new ProductosDAO();
        final int resultadoEsperado = 2;
        
        List<Producto> productos = productosDAO.consultar(filtroBusqueda);
        assertNotNull(productos);
        assertEquals(resultadoEsperado, productos.size());
    }
    
}
