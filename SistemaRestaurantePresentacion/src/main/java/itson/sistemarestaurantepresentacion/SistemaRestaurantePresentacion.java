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
//        BuscadorProductos formBuscadorProductos = new BuscadorProductos(productosBO);
//        AgregarIngredientes agregarIngredientes = new AgregarIngredientes(ingredientesBO);
//        agregarIngredientes.setVisible(true);
//        agregarIngredientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Ingredientes formAgregarProducto = new Ingredientes(ingredientesBO);
//        ActualizarIngredientes act = new ActualizarIngredientes(ingredientesBO);
//        formAgregarProducto.setVisible(true);

//        BuscadorProductos formBuscadorProductos = new BuscadorProductos(productosBO);
//        formBuscadorProductos.setVisible(true);
//        AgregarIngredientes agregarIngredientes = new AgregarIngredientes(ingredientesBO);
//        agregarIngredientes.setVisible(true);
//        agregarIngredientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        AgregarIngredientesProducto formAgregarProducto = new AgregarIngredientesProducto(productosBO);
//        formAgregarProducto.setVisible(true);

        //ListaProductos listaProductos = new ListaProductos(productosBO);
        MenuAdministrador menuAdministrador = new MenuAdministrador();
        menuAdministrador.setVisible(true);
        

        
    }
}
