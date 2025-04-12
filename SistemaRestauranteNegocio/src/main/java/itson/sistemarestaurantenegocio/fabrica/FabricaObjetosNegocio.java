
package itson.sistemarestaurantenegocio.fabrica;

import itson.sistemarestaurantenegocio.IClientesBO;
import itson.sistemarestaurantenegocio.IComandasBO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.IIngredientesProductosBO;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.implementaciones.ClientesBO;
import itson.sistemarestaurantenegocio.implementaciones.ComandasBO;
import itson.sistemarestaurantenegocio.implementaciones.IngredientesBO;
import itson.sistemarestaurantenegocio.implementaciones.IngredientesProductosBO;
import itson.sistemarestaurantenegocio.implementaciones.ProductosBO;
import itson.sistemarestaurantepersistencia.IClientesDAO;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ClientesDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ComandasDAO;
import itson.sistemarestaurantepersistencia.implementaciones.IngredientesDAO;
import itson.sistemarestaurantepersistencia.implementaciones.IngredientesProductoDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ProductosDAO;

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
    
}
