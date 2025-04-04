package itson.sistemarestaurantepresentacion.control;

import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.fabrica.FabricaObjetosNegocio;
import itson.sistemarestaurantepresentacion.ActualizarIngredientes;
import itson.sistemarestaurantepresentacion.AgregarIngredientes;
import itson.sistemarestaurantepresentacion.AgregarIngredientesProducto;
import itson.sistemarestaurantepresentacion.MenuAdministrador;

/**
 *
 * @author Juan Heras, Pedro Esquer & Victoria Soto
 */
public class Control {

    private static Control instance;
    IIngredientesBO ingredientesBO = FabricaObjetosNegocio.crearIngredientesBO();

    /**
     * Constructor privado para evitar la creación externa de instancias.
     */
    private Control() {
    }

    /**
     * Método para obtener la instancia del singleton.
     *
     * @return una instancia de tipo Control.
     */
    public static Control getInstancia() {
        if (instance == null) {
            instance = new Control();
        }
        return instance;
    }

    /**
     * Método que abre la pantalla para registrar los ingredientes de un
     * producto,
     *
     * @param id del producto al cual se le van a relacionar los ingredientes.
     */
    public void abrirAgregarIngredientesProducto(Long id) {
        AgregarIngredientesProducto formAgregarIngredientesProducto = new AgregarIngredientesProducto(id);
        formAgregarIngredientesProducto.setVisible(true);
    }

    public void abrirActualizarStockIngredientes() {
        ActualizarIngredientes formActualizarIngredientes = new ActualizarIngredientes(ingredientesBO);
        formActualizarIngredientes.setVisible(true);
    }

    public void abrirMenuAdministrador() {
        MenuAdministrador formMenuAdministrador = new MenuAdministrador();
        formMenuAdministrador.setVisible(true);
    }

    public void abrirAgregarIngredientes() {
        AgregarIngredientes formAgregarIngredientes = new AgregarIngredientes(ingredientesBO);
        formAgregarIngredientes.setVisible(true);
    }
    
    

}
