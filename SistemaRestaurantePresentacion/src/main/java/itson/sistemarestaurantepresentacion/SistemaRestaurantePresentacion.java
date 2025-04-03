/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

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
        BuscadorProductos formBuscadorProductos = new BuscadorProductos(productosBO);
        AgregarIngredientes agregarIngredientes = new AgregarIngredientes(ingredientesBO);
        agregarIngredientes.setVisible(true);
        agregarIngredientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
