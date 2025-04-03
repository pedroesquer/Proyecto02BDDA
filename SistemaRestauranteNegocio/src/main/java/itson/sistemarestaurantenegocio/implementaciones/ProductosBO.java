
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.ActualizarProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.IProductosDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public class ProductosBO implements IProductosBO {

    private IProductosDAO productosDAO;
    private static final int LIMITE_CARACTERES_NOMBRE = 50;
    private static final int LIMITE_FILTRO_BUSQUEDA = 50;

    public ProductosBO(IProductosDAO productosDAO) {
        this.productosDAO = productosDAO;
    }
    
    
    
    /**
     * Método registrar producto que se encarga de validar todas las reglas de un registro antes de mandarlo a la
     * @param nuevoProducto
     * @return El producto que se registró
     * @throws NegocioException 
     */
    @Override
    public Producto registrar(NuevoProductoDTO nuevoProducto) throws NegocioException {
        if(nuevoProducto.getPrecio() <= 0 ){
            throw new NegocioException("El precio debe de ser mayor a 0");
        }
        
        if(nuevoProducto.getNombre() == null || nuevoProducto.getNombre().isBlank()){
            throw new NegocioException("Debes proporcionar un nombre para el producto");
        }
        
        if(nuevoProducto.getNombre().length() > LIMITE_CARACTERES_NOMBRE){
            throw new NegocioException("El nombre del producto es demasiado largo");
        }
        return this.productosDAO.registrar(nuevoProducto);
    }

    /**
     * Método que busca coincidencias con el filtro de busqueda ingresado.
     * @param filtroBusqueda
     * @return La lista con las coincidencias encontradas.
     * @throws NegocioException 
     */
    @Override
    public List<Producto> consultar(String filtroBusqueda) throws NegocioException {
        if(filtroBusqueda.length() > LIMITE_FILTRO_BUSQUEDA){
            throw new NegocioException("El filtro de busqueda es demasiado largo");
        }
        return this.productosDAO.consultar(filtroBusqueda);
    }

    /**
     * Método para actualizar un producto en la base de datos, se puede cambiar su nombre y/o precio
     * @param actualizarProducto
     * @return
     * @throws NegocioException 
     */
    @Override
    public Producto actualizar(ActualizarProductoDTO actualizarProducto) throws NegocioException, PersistenciaException {
        if(actualizarProducto.getPrecio() <= 0 ){
            throw new NegocioException("El precio debe de ser mayor a 0");
        }
        if(actualizarProducto.getNombre().length() > LIMITE_CARACTERES_NOMBRE){
            throw new NegocioException("El nombre es demasiado largo");
        }
        return this.productosDAO.actualizarProducto(actualizarProducto);
    }
    
    
    
}
