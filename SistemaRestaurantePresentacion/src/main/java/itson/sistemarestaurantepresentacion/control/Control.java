package itson.sistemarestaurantepresentacion.control;

import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.fabrica.FabricaObjetosNegocio;
import itson.sistemarestaurantepresentacion.ActualizarIngredientes;
import itson.sistemarestaurantepresentacion.ActualizarProducto;
import itson.sistemarestaurantepresentacion.ActualizarStock;
import itson.sistemarestaurantepresentacion.AgregarIngredientes;
import itson.sistemarestaurantepresentacion.AgregarIngredientesProducto;
import itson.sistemarestaurantepresentacion.BuscadorIngredientes;
import itson.sistemarestaurantepresentacion.Ingredientes;
import itson.sistemarestaurantepresentacion.ListaIngredientes;
import itson.sistemarestaurantepresentacion.MenuAdministrador;
import java.util.List;

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
     *
     * @param id del producto a actualizar.
     */
    public void abrirActualizarProducto(Long id) {
        ActualizarProducto formActualizarProducto = new ActualizarProducto(id);
        formActualizarProducto.setVisible(true);

    }

    /**
     * Método que abre la pantalla de opciones de ingrediente.
     */
    public void abrirIngredientes() {
        Ingredientes formIngredientes = new Ingredientes(ingredientesBO);
        formIngredientes.setVisible(true);
    }

    /**
     * Método que abre la pantalla del buscador de ingrediente.
     */
    public void abrirBuscadorIngredientes(String origen) {
        BuscadorIngredientes formBuscadorIngredientes = new BuscadorIngredientes(ingredientesBO, origen);
        formBuscadorIngredientes.setVisible(true);
    }

    /**
     * Método que abre la pantalla de la lista de ingredientes.
     */
    public void abrirListaIngredientes() {
        ListaIngredientes formListaIngredientes = new ListaIngredientes(ingredientesBO);
        formListaIngredientes.setVisible(true);
    }

    /**
     * Método que abre la pantalla de la lista de ingredientes filtrada.
     */
    public void abrirListaIngredientesFiltrada(NuevoIngredienteDTO ingredienteSeleccionado) {
        ListaIngredientes formListaIngredientes = new ListaIngredientes(ingredientesBO);
        formListaIngredientes.actualizarIngredientesSeleccionados(ingredienteSeleccionado);
        formListaIngredientes.setVisible(true);
    }
    
    /**
     * Método que abre la pantalla del actualizador de stock.
     * @param ingredienteSeleccionado NuevoIngredienteDTO que se genera por medio de la selección dentro del buscador de productos
     */
    public void abrirActualizarStock(NuevoIngredienteDTO ingredienteSeleccionado) {
        ActualizarStock formBuscadorIngredientes = new ActualizarStock(ingredientesBO);
        formBuscadorIngredientes.actualizarIngredientesSeleccionados(ingredienteSeleccionado);
        formBuscadorIngredientes.setVisible(true);
    }

}
