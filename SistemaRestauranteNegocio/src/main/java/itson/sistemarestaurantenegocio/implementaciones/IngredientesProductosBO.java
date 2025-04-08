
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.IngredienteProducto;
import itson.sistemarestaurantedominio.dtos.ActualizarIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.DetalleIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevaRelacionIngredienteProductoDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IIngredientesProductosBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.IIngredientesProductosDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
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

    @Override
    public IngredienteProducto registrarRelacion(NuevaRelacionIngredienteProductoDTO relacionIngredienteProductoDTO) throws NegocioException, PersistenciaException {
        if(relacionIngredienteProductoDTO.getCantidad() <= 0){
            throw new NegocioException("No puedes dejar cantidades en 0");
        }
        return this.ingredientesProductosDAO.registrar(relacionIngredienteProductoDTO);
    }

    @Override
    public IngredienteProducto actualizar(ActualizarIngredienteProductoDTO actualizarIngredienteProducto) throws NegocioException, PersistenciaException {
        if(actualizarIngredienteProducto.getCantidad() <= 0){
            throw new NegocioException("No se puede actualizar la cantidad porque es 0");
        }
        return this.ingredientesProductosDAO.actualizar(actualizarIngredienteProducto);
    }
    
    

    
    
     
}
