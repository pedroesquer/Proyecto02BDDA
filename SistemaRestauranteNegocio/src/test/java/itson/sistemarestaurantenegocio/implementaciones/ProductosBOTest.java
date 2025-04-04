/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import itson.sistemarestaurantepersistencia.implementaciones.ProductosDAO;
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
public class ProductosBOTest {
    
    public ProductosBOTest() {
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

//    /**
//     * Test of registrar method, of class ProductosBO.
//     */
//    @Test
//    public void testRegistrarNombreDupicladoArrojaExcepcion() throws Exception {
//        ProductosDAO productosDAO = new ProductosDAO();
//        IProductosBO productosBO = new ProductosBO(productosDAO); 
//        NuevoProductoDTO nuevoProductoDTO = new NuevoProductoDTO("Nachos con carne", 250f, TipoProducto.PLATILLO);
//            
//        
//        
//        NegocioException ex = assertThrows(NegocioException.class,
//                ()->  productosBO.registrar(nuevoProductoDTO)
//        );
//        
//        String mensajeEsperado = "El producto ya existe";
//        assertEquals(mensajeEsperado, ex.getMessage());
//        
//    }

}
