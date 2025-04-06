
package itson.sistemarestaurantenegocio.fabrica;

import itson.sistemarestaurantedominio.IngredienteProducto;
import itson.sistemarestaurantedominio.dtos.ActualizarIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.DetalleIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevaRelacionIngredienteProductoDTO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.IIngredientesProductosBO;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.implementaciones.IngredientesBO;
import itson.sistemarestaurantenegocio.implementaciones.IngredientesProductosBO;
import itson.sistemarestaurantenegocio.implementaciones.ProductosBO;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import itson.sistemarestaurantepersistencia.implementaciones.IngredientesDAO;
import itson.sistemarestaurantepersistencia.implementaciones.IngredientesProductoDAO;
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
    
}
