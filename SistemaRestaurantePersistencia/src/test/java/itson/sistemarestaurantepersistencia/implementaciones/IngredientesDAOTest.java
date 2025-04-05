package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.UnidadMedida;
import static itson.sistemarestaurantedominio.UnidadMedida.GRAMOS;
import itson.sistemarestaurantedominio.dtos.ActualizarStockIngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Soto
 */
public class IngredientesDAOTest {

    public IngredientesDAOTest() {
    }

    /**
     * Test of registrar method, of class IngredientesDAO.
     */
    @Test
    public void testRegistrarIngredienteOk() {
        //Creamos DAO
        IngredientesDAO ingredientesDAO = new IngredientesDAO();
        //Creamos el nuevo ingrediente
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO("a", 500, GRAMOS);
        //Registramos el nuevo ingrediente
        Ingrediente ingrediente = ingredientesDAO.registrar(nuevoIngrediente);
        //Verificamos que su ID no venga nulo.
        assertNotNull(ingrediente.getId());
        //Verificamos que ciertos atributos del ingrediente que creamos nosotros y el que se registró sean igual.
        assertEquals(nuevoIngrediente.getNombre(), ingrediente.getNombre());
        assertEquals(nuevoIngrediente.getStock(), ingrediente.getStock());
        
        ingredientesDAO.eliminar(ingrediente.getId());
    }

    @Test 
    public void testActualizarStockOk(){
        //Creamos DAO
        IngredientesDAO ingredientesDAO = new IngredientesDAO();
        ActualizarStockIngredienteDTO ingredienteActualizado = new ActualizarStockIngredienteDTO(1L, 1500);
        
        Ingrediente ingrediente = ingredientesDAO.agregarStock(ingredienteActualizado);
        
        assertEquals(ingrediente.getStock(), ingredienteActualizado.getStock());
    }
    
    
    @Test
    public void testRegistrarIngredienteSinNombre() {
        //Creamos DAO
        IngredientesDAO ingredientesDAO = new IngredientesDAO();
        //Creamos el nuevo ingrediente con nombre nulo
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(null, 500, GRAMOS);
        //Realizamos un assertThrows que se encarga de verificar si tira la excepción, si la tira es que no deja agregar ingredientes sin nombre
        Exception ex = assertThrows(Exception.class, () -> ingredientesDAO.registrar(nuevoIngrediente));
    }

    @Test
    public void testRegistrarIngredienteSinStock() {
        //Creamos DAO
        IngredientesDAO ingredientesDAO = new IngredientesDAO();
        //Creamos el nuevo ingrediente con stock nulo
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO("Tomate", null, GRAMOS);
        //Realizamos un assertThrows que se encarga de verificar si tira la excepción, si la tira es que no deja agregar ingredientes sin stock
        Exception ex = assertThrows(Exception.class, () -> ingredientesDAO.registrar(nuevoIngrediente));
    }

    @Test
    public void testConsultarIngredientesOk() {
        //Creamos DAO
        IngredientesDAO ingredientesDAO = new IngredientesDAO();
        //Asignamos una variable constante con la cantidad de registros que hay de ingredientes
        final int resultadoIngredienteEsperado = 4;
        //Creamos una lista utilizando el metodo de consultar ingredientes de la DAO
        List<Ingrediente> ingredientes = ingredientesDAO.consultarIngredientes("GRAMOS");
        //Hacemos un assertNotNull para ver si es que viene nulo
        assertNotNull(ingredientes);
        //Comparamos nuestra variable constante con la longitud de la lista.
        assertEquals(resultadoIngredienteEsperado, ingredientes.size());
    }

    @Test
    public void testConsultarIngredientesNombre() {
        //Creamos DAO
        IngredientesDAO ingredientesDAO = new IngredientesDAO();
        //Asignamos una variable constante con la cantidad de registros que hay de ingredientes filtrados
        final int resultadoIngredienteEsperado = 1;
        //Creamos una lista utilizando el metodo de consultar ingredientes de la base de datos con un nombre en específico
        List<Ingrediente> ingredientes = ingredientesDAO.consultarIngredientesNombre("Lechuga");
        //Hacemos un assertNotNull para ver si es que viene nulo
        assertNotNull(ingredientes);
        //Comparamos nuestra variable constante con la longitud de la lista.
        assertEquals(resultadoIngredienteEsperado, ingredientes.size());
    }

    @Test
    public void testConsultarIngredientesUnidadMedida() {
        //Creamos DAO
        IngredientesDAO ingredientesDAO = new IngredientesDAO();
        //Asignamos una variable constante con la cantidad de registros que hay de ingredientes filtrados
        final int resultadoIngredienteEsperadoConsulta = 4;
        //Creamos una lista utilizando el metodo de consultar ingredientes de la base de datos con una unidad en específico
        List<Ingrediente> ingredientes = ingredientesDAO.consultarIngredientesUnidad(GRAMOS);
        //Hacemos un assertNotNull para ver si es que viene nulo
        assertNotNull(ingredientes);
        //Comparamos nuestra variable constante con la longitud de la lista.
        assertEquals(resultadoIngredienteEsperadoConsulta, ingredientes.size());
    }

}
