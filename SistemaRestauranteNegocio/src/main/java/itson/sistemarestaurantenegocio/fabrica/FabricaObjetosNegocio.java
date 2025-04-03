
package itson.sistemarestaurantenegocio.fabrica;

import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.implementaciones.ProductosBO;
import itson.sistemarestaurantepersistencia.IProductosDAO;
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
    
}
