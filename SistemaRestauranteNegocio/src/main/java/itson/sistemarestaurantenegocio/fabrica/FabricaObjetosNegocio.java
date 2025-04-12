
package itson.sistemarestaurantenegocio.fabrica;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantenegocio.IClientesBO;
import itson.sistemarestaurantenegocio.IComandasBO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.IIngredientesProductosBO;
import itson.sistemarestaurantenegocio.IMesasBO;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.IProductosComandaBO;
import itson.sistemarestaurantenegocio.implementaciones.ClientesBO;
import itson.sistemarestaurantenegocio.implementaciones.ComandasBO;
import itson.sistemarestaurantenegocio.implementaciones.IngredientesBO;
import itson.sistemarestaurantenegocio.implementaciones.IngredientesProductosBO;
import itson.sistemarestaurantenegocio.implementaciones.MesasBO;
import itson.sistemarestaurantenegocio.implementaciones.ProductosBO;
import itson.sistemarestaurantenegocio.implementaciones.ProductosComandaBO;
import itson.sistemarestaurantepersistencia.IClientesDAO;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;
import itson.sistemarestaurantepersistencia.IMesasDAO;
import itson.sistemarestaurantepersistencia.IProductosComandaDAO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ClientesDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ComandasDAO;
import itson.sistemarestaurantepersistencia.implementaciones.IngredientesDAO;
import itson.sistemarestaurantepersistencia.implementaciones.IngredientesProductoDAO;
import itson.sistemarestaurantepersistencia.implementaciones.MesasDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ProductosComandaDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ProductosDAO;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public class FabricaObjetosNegocio {
    public static IProductosBO crearProductosBO(){
        IProductosDAO productosDAO = new ProductosDAO();
        IProductosBO productosBO = new ProductosBO(productosDAO);
        return productosBO;
    }
    
    public static IIngredientesBO crearIngredientesBO(){
        IIngredientesDAO ingredientesDAO = new IngredientesDAO();
        IIngredientesBO ingredientesBO = new IngredientesBO(ingredientesDAO);
        return ingredientesBO;
    }
    
    public static IIngredientesProductosBO crearIngredientesProductos(){
        IIngredientesProductosDAO ingredientesProductosDAO = new IngredientesProductoDAO();
        IIngredientesProductosBO ingredientesProductoBO = new IngredientesProductosBO(ingredientesProductosDAO);
        return ingredientesProductoBO;
    }
    
    public static IClientesBO crearClientesBO(){
        IClientesDAO clientesDAO = new ClientesDAO();
        IClientesBO clientesBO = new ClientesBO(clientesDAO);
        return clientesBO;
    }
    
    public static IComandasBO crearComandasBO(){
        IComandasDAO comandasDAO = new ComandasDAO();
        IComandasBO comandasBO = new ComandasBO(comandasDAO);
        return comandasBO;
    }
    
    public static IProductosComandaBO crearProductoComandaBO(){
        IProductosComandaDAO productosComandaDAO = new ProductosComandaDAO();
        IProductosComandaBO productosComandaBO = new ProductosComandaBO(productosComandaDAO);
        return productosComandaBO;
    }
    
    public static IMesasBO crearMesasBO(){
        IMesasDAO mesasDAO = new MesasDAO() ;
        IMesasBO mesasBO = new MesasBO(mesasDAO);
        return mesasBO;
    }
    
}
