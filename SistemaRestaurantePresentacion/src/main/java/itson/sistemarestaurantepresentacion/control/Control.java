package itson.sistemarestaurantepresentacion.control;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IClientesBO;
import itson.sistemarestaurantenegocio.IComandasBO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.IIngredientesProductosBO;
import itson.sistemarestaurantenegocio.IMesasBO;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.IProductosComandaBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.fabrica.FabricaObjetosNegocio;
import itson.sistemarestaurantepresentacion.ingredientes.ActualizarIngredientes;
import itson.sistemarestaurantepresentacion.productos.ActualizarProducto;
import itson.sistemarestaurantepresentacion.ingredientes.ActualizarStock;
import itson.sistemarestaurantepresentacion.clientes.AgregarCliente;
import itson.sistemarestaurantepresentacion.ingredientes.AgregarIngredientes;
import itson.sistemarestaurantepresentacion.productos.AgregarIngredientesProducto;
import itson.sistemarestaurantepresentacion.productos.AgregarProducto;
import itson.sistemarestaurantepresentacion.ingredientes.BuscadorIngredientes;
import itson.sistemarestaurantepresentacion.productos.BuscadorProductos;
import itson.sistemarestaurantepresentacion.clientes.ClientesFrecuentes;
import itson.sistemarestaurantepresentacion.productos.DetallesProducto;
import itson.sistemarestaurantepresentacion.ingredientes.Ingredientes;
import itson.sistemarestaurantepresentacion.ingredientes.ListaIngredientes;
import itson.sistemarestaurantepresentacion.productos.ListaProductos;
import itson.sistemarestaurantepresentacion.MenuAdministrador;
import itson.sistemarestaurantepresentacion.clientes.BuscadorClientes;
import itson.sistemarestaurantepresentacion.comandas.AgregarComanda;
import itson.sistemarestaurantepresentacion.comandas.Comandas;
import itson.sistemarestaurantepresentacion.comandas.DetallesComanda;
import itson.sistemarestaurantepresentacion.comandas.ListaComandas;
import itson.sistemarestaurantepresentacion.productos.Productos;
import itson.sistemarestaurantepresentacion.productos.FrmAgregarIngredientes;
import itson.sistemarestaurantepresentacion.observers.IngredienteSeleccionadoObserver;
import itson.sistemarestaurantepresentacion.observers.ProductoSeleccionadoObserver;
import itson.sistemarestaurantepresentacion.productos.ActualizarPreciosProductos;
import itson.sistemarestaurantepresentacion.reportes.GenerarReporte;
import itson.sistemarestaurantepresentacion.reportes.ReporteComandas;
import itson.sistemarestaurantepresentacion.reportes.Reportes;
import java.util.Date;
import java.util.function.Consumer;
import javax.swing.JFrame;

/**
 *
 * @author Juan Heras, Pedro Esquer & Victoria Soto
 */
public class Control {

    private static Control instance;
    IIngredientesBO ingredientesBO = FabricaObjetosNegocio.crearIngredientesBO();
    IProductosBO productosBO = FabricaObjetosNegocio.crearProductosBO();
    IIngredientesProductosBO ingredientesProductoBO = FabricaObjetosNegocio.crearIngredientesProductos();
    IClientesBO clientesBO = FabricaObjetosNegocio.crearClientesBO();
    IComandasBO comandasBO = FabricaObjetosNegocio.crearComandasBO();
    IProductosComandaBO  prp = FabricaObjetosNegocio.crearProductoComandaBO();
    IMesasBO mesasBO = FabricaObjetosNegocio.crearMesasBO();
    MenuAdministrador formMenuAdministrador;

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
        AgregarIngredientesProducto formAgregarIngredientesProducto = new AgregarIngredientesProducto(id, ingredientesProductoBO);
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
        if (formMenuAdministrador == null) {
            formMenuAdministrador = new MenuAdministrador();
        }
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
    public void abrirActualizarProducto(Producto producto) {
        ActualizarProducto formActualizarProducto = new ActualizarProducto(producto, ingredientesProductoBO);
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
     *
     * @param observer
     */
    public void abrirBuscadorIngredientes(IngredienteSeleccionadoObserver observer) {
        BuscadorIngredientes formBuscadorIngredientes = new BuscadorIngredientes(ingredientesBO);
        formBuscadorIngredientes.agregarObserver(observer);
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
     * Método que abre la pantalla del actualizador de stock.
     *
     * @param ingredienteSeleccionado NuevoIngredienteDTO que se genera por
     * medio de la selección dentro del buscador de productos
     */
    public void abrirActualizarStock(NuevoIngredienteDTO ingredienteSeleccionado) {
        ActualizarStock formBuscadorIngredientes = new ActualizarStock(ingredientesBO);
        formBuscadorIngredientes.actualizarIngredientesSeleccionados(ingredienteSeleccionado);
        formBuscadorIngredientes.setVisible(true);
    }

    /**
     * Método que abre la pantalla de menu de Productos.
     */
    public void abrirProductos() {
        Productos formProductos = new Productos();
        formProductos.setVisible(true);
    }

    /**
     * Método que abre el frame de agregar el Producto.
     */
    public void abrirAgregarProducto() {
        AgregarProducto formAgregarProducto = new AgregarProducto(productosBO);
        formAgregarProducto.setVisible(true);
    }

    /**
     * Método que abre la lista de Productos en existencia despues de haber
     * seleccionado actualizar o ver productos.
     */
    public void abrirListaProductos() {
        ListaProductos formListaProductos = new ListaProductos(productosBO);
        formListaProductos.setVisible(true);
    }

    /**
     * Método que abre la pantalla de detalles de un producto, donde muestra sus
     * ingredientes y su nombre.
     */
    public void abrirDetallesProducto(Producto productoDetallar) {
        DetallesProducto formDetallesProducto = new DetallesProducto(productoDetallar, ingredientesProductoBO);
        formDetallesProducto.setVisible(true);
    }

    /**
     * Metodo que abre la pantalla de clientes frecuentes.
     */
    public void abrirClientesFrecuentes() {
        ClientesFrecuentes formClientesFrecuentes = new ClientesFrecuentes(clientesBO);
        formClientesFrecuentes.setVisible(true);
    }

    /**
     * Metodo que abre la pantalla de clientes frecuentes.
     */
    public void abrirActualizarIngredientes() {
        ActualizarIngredientes formActualizarIngredientes = new ActualizarIngredientes(ingredientesBO);
        formActualizarIngredientes.setVisible(true);
    }

    public JFrame abrirFrameAgregarIngredientes(Producto producto) {
        FrmAgregarIngredientes formAgregarIngredientes = new FrmAgregarIngredientes(producto, ingredientesProductoBO);
        formAgregarIngredientes.setVisible(true);
        return formAgregarIngredientes;
    }

    public void abrirBuscadorProductos(ProductoSeleccionadoObserver observer) {
        BuscadorProductos formBuscadorProductos = new BuscadorProductos(productosBO);
        formBuscadorProductos.agregarObserver(observer);
        formBuscadorProductos.setVisible(true);
    }

    public void abrirAgregarCliente() {
        AgregarCliente formAgregarCliente = new AgregarCliente(clientesBO);
        formAgregarCliente.setVisible(true);
    }

    public void abrirActualizarPreciosProductos() {
        ActualizarPreciosProductos formActualizarProductos = new ActualizarPreciosProductos(productosBO);
        formActualizarProductos.setVisible(true);

    }

    public void abrirBuscadorClientes(IClientesBO clientesBO, Consumer<Cliente> onClienteSeleccionado) {
        BuscadorClientes buscador = new BuscadorClientes(clientesBO, onClienteSeleccionado);
        buscador.setVisible(true);
    }

    public void volverAlMenuPrincipal(JFrame ventanaActual) {
        ventanaActual.dispose();
        abrirMenuAdministrador();
    }

    public void abrirComandas() {
        Comandas formComandas = new Comandas(comandasBO);
        formComandas.setVisible(true);
    }

    public void abrirListaComandas() {
        ListaComandas formListaComandas = new ListaComandas(comandasBO);
        formListaComandas.setVisible(true);
    }
    
    public void abrirDetallesComanda(Long idComanda){
        DetallesComanda formDetallesComanda = new DetallesComanda(idComanda, comandasBO, prp);
        formDetallesComanda.setVisible(true);
    }
    
    public void abrirAgregarComandas() {
        AgregarComanda formAgregarComanda = new AgregarComanda(comandasBO, mesasBO);
        formAgregarComanda.setVisible(true);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void abrirGenerarReporte(Date fechaInicio, Date fechaFin) {
        GenerarReporte formGenerarReporte = new GenerarReporte(fechaInicio, fechaFin);
        formGenerarReporte.setVisible(true);

    }

    public void abrirReporteComandas() {
        ReporteComandas formReporteComandas = new ReporteComandas();
        formReporteComandas.setVisible(true);
    }

    public void abrirReportes() {
        Reportes formReporteComandas = new Reportes();
        formReporteComandas.setVisible(true);
    }
}
