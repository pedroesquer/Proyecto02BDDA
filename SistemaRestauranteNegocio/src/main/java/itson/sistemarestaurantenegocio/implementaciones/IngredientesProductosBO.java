
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.dtos.DetalleIngredienteProductoDTO;
import itson.sistemarestaurantenegocio.IIngredientesProductosBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public class IngredientesProductosBO implements IIngredientesProductosBO {

    private IIngredientesProductosDAO ingredientesProductosDAO;

    public IngredientesProductosBO(IIngredientesProductosDAO ingredientesProductosDAO) {
        this.ingredientesProductosDAO = ingredientesProductosDAO;
    }
    
    

    @Override
    public List<DetalleIngredienteProductoDTO> consultarIngredientesProducto(Long idProducto) throws NegocioException {
        if(idProducto == null){
            throw new NegocioException("El producto a buscar detalles ya no existe");
        }
        return this.ingredientesProductosDAO.consultarIngredientesProducto(idProducto);
    }
    
    
    
    
}
