package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.UnidadMedida;
import static itson.sistemarestaurantedominio.UnidadMedida.GRAMOS;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class IngredientesDAOTest {
    
    public IngredientesDAOTest() {
    }

    /**
     * Test of registrar method, of class IngredientesDAO.
     */
    @Test
    public void testRegistrarOk() {
        //Creamos DAO
        IngredientesDAO ingredientesDAO = new IngredientesDAO();
        //Creamos el nuevo ingrediente
        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO("Pepperoni", 1000F, GRAMOS);
        //Registramos el nuevo ingrediente
        Ingrediente ingrediente = ingredientesDAO.registrar(nuevoIngrediente);
        //Verificamos que su ID no venga nulo.
        assertNotNull(ingrediente.getId());
        //Verificamos que ciertos atributos del ingrediente que creamos nosotros y el que se registró sean igual.
        assertEquals(nuevoIngrediente.getNombre(), ingrediente.getNombre());
        assertEquals(nuevoIngrediente.getStock(), ingrediente.getStock());
    }
    
}
