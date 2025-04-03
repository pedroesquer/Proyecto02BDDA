/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.IngredienteProducto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantedominio.UnidadMedida;
import itson.sistemarestaurantedominio.dtos.NuevaRelacionIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.Arrays;
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
public class IngredientesProductoDAOTest {
    
    public IngredientesProductoDAOTest() {
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
     * Test of registrar method, of class IngredientesProductoDAO.
     * @throws itson.sistemarestaurantepersistencia.excepciones.PersistenciaException
     */
    @Test
    public void testRegistrarRelacionIngredienteProductoOk() throws PersistenciaException{
        //Primero creamos una DAO de la relación 
        IngredientesProductoDAO ingredientesProductosDAO = new IngredientesProductoDAO();
        NuevaRelacionIngredienteProductoDTO nuevaRelacion= new NuevaRelacionIngredienteProductoDTO();
        
        nuevaRelacion.setIdProducto(1);
        nuevaRelacion.setIdIngrediente(3);
        nuevaRelacion.setCantidad(150f);
        
        IngredienteProducto ingredienteProductoGuardado = ingredientesProductosDAO.registrar(nuevaRelacion);
        
        assertNotNull(ingredienteProductoGuardado.getId());
        
        assertEquals(nuevaRelacion.getIdProducto(), ingredienteProductoGuardado.getProducto().getId());
        assertEquals(nuevaRelacion.getIdIngrediente(), ingredienteProductoGuardado.getIngrediente().getId());
    }
    
    @Test
    public void testRegistrarRelacionConProductoInexistenteArrojaPersistenciaException(){
        IngredientesProductoDAO ingredientesProductosDAO = new IngredientesProductoDAO();
        NuevaRelacionIngredienteProductoDTO nuevaRelacion= new NuevaRelacionIngredienteProductoDTO();
        
        nuevaRelacion.setIdProducto(230);
        nuevaRelacion.setIdIngrediente(2);
        nuevaRelacion.setCantidad(150f);
        
        //Ahora verificamos que la excepción se lanze
        PersistenciaException ex = assertThrows(PersistenciaException.class,
                ()-> ingredientesProductosDAO.registrar(nuevaRelacion)
        );
        
        //Ahora verificamos que se lance el mensaje esperado, en este caso del producto
        String mensajeEsperado = "El producto no existe";
        assertEquals(mensajeEsperado, ex.getMessage());
        
    }
    
    @Test
    public void testRegistrarRelacionConIngredienteInexistenteArrojaPersistenciaException(){
        IngredientesProductoDAO ingredientesProductosDAO = new IngredientesProductoDAO();
        NuevaRelacionIngredienteProductoDTO nuevaRelacion= new NuevaRelacionIngredienteProductoDTO();
        
        nuevaRelacion.setIdProducto(1);
        nuevaRelacion.setIdIngrediente(203); //Ponemos un id que no tengamos
        nuevaRelacion.setCantidad(150f);
        
        //Ahora verificamos que la excepción se lanze
        PersistenciaException ex = assertThrows(PersistenciaException.class,
                ()-> ingredientesProductosDAO.registrar(nuevaRelacion)
        );
        
        //Ahora verificamos que se lance el mensaje esperado, en este caso del producto
        String mensajeEsperado = "El ingrediente no existe";
        assertEquals(mensajeEsperado, ex.getMessage());
        
    }
    

    
}
