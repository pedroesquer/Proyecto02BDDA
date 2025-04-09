package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.fabrica.FabricaObjetosNegocio;
import javax.swing.JFrame;

/**
 *
 * @author pedro
 */
public class SistemaRestaurantePresentacion {

    public static void main(String[] args) {
        IProductosBO productosBO = FabricaObjetosNegocio.crearProductosBO();
        IIngredientesBO ingredientesBO = FabricaObjetosNegocio.crearIngredientesBO();
        MenuAdministrador menuAdministrador = new MenuAdministrador();
        menuAdministrador.setVisible(true);
        

        
    }
}
