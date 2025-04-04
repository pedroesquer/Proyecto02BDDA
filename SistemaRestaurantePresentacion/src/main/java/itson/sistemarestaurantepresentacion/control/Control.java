package itson.sistemarestaurantepresentacion.control;

import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.fabrica.FabricaObjetosNegocio;
import itson.sistemarestaurantepresentacion.ActualizarIngredientes;
import itson.sistemarestaurantepresentacion.AgregarIngredientes;
import itson.sistemarestaurantepresentacion.AgregarIngredientesProducto;
import itson.sistemarestaurantepresentacion.Ingredientes;
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

    /**
    * Método que abre la pantalla para actualizar el stock de ingredientes.
    */
    public void abrirActualizarStockIngredientes() {
        ActualizarIngredientes formActualizarIngredientes = new ActualizarIngredientes(ingredientesBO);
        formActualizarIngredientes.setVisible(true);
    }

    /**
    * Método que abre la pantalla del menú del administrador.
    */
    public void abrirMenuAdministrador() {
        MenuAdministrador formMenuAdministrador = new MenuAdministrador();
        formMenuAdministrador.setVisible(true);
    }

    /**
    * Método que abre la pantalla de agregar ingredientes.
    */
    public void abrirAgregarIngredientes() {
        AgregarIngredientes formAgregarIngredientes = new AgregarIngredientes(ingredientesBO);
        formAgregarIngredientes.setVisible(true);
    }
    
    /**
     * Método que abre la pantalla para actualizar un producto
     * @param id del producto a actualizar.
     */
    public void abrirActualizarProducto(Long id){
        
    }
    
    /**
    * Método que abre la pantalla de opciones de ingrediente.
    */
    public void abrirIngredientes(){
        Ingredientes formIngredientes = new Ingredientes(ingredientesBO);
        formIngredientes.setVisible(true);
    }
    

}
