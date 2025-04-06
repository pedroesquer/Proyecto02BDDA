package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.ActualizarStockIngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Soto
 */
public class IngredientesBO implements IIngredientesBO {

    private IIngredientesDAO ingredientesDAO;
    private static final int LIMITE_CARACTERES_NOMBRE = 50;

    private static final int LIMITE_FILTRO_BUSQUEDA = 50;

    public IngredientesBO(IIngredientesDAO ingredientesDAO) {
        this.ingredientesDAO = ingredientesDAO;
    }

    /**
     * Registra un nuevo ingrediente en el sistema, validando los datos
     * proporcionados.
     *
     * @param nuevoIngrediente El objeto que contiene los datos del ingrediente
     * a registrar.
     * @return El ingrediente registrado si la operación es exitosa.
     * @throws NegocioException Si alguno de los datos del ingrediente no es
     * válido o ya existe.
     */
    @Override
    public Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException {
        if (nuevoIngrediente.getNombre() == null || nuevoIngrediente.getNombre().isBlank()) {
            throw new NegocioException("Debes proporcionar un nombre para el producto");
        }

        if (nuevoIngrediente.getNombre().length() > LIMITE_CARACTERES_NOMBRE) {
            throw new NegocioException("El nombre del producto es demasiado largo");
        }

        if (nuevoIngrediente.getStock() < 0) {
            throw new NegocioException("El stock debe ser mayor a 0");
        }

        if (ingredientesDAO.consultarIngredientePorNombreYUnidad(nuevoIngrediente.getNombre(),
                nuevoIngrediente.getUnidadMedida()) != null) {
            throw new NegocioException("Ya existe un ingrediente con el mismo nombre y unidad de medida.");
        }

        if (nuevoIngrediente.getNombre().matches(".*\\d.*")) {
            throw new NegocioException("El nombre del producto no debe contener números");
        }

        return this.ingredientesDAO.registrar(nuevoIngrediente);
    }

    /**
     * Consulta los ingredientes en el sistema, aplicando un filtro de búsqueda.
     *
     * @param filtroBusqueda El texto para filtrar los ingredientes.
     * @return Una lista de ingredientes que cumplen con el filtro de búsqueda.
     * @throws NegocioException Si el filtro de búsqueda es demasiado largo.
     */
    @Override
    public List<Ingrediente> consultar(String filtroBusqueda) throws NegocioException {
        if (filtroBusqueda.length() > LIMITE_FILTRO_BUSQUEDA) {
            throw new NegocioException("El filtro de busqueda es demasiado largo");
        }
        return this.ingredientesDAO.consultarIngredientes(filtroBusqueda);
    }

    /**
     * Actualiza el stock de un ingrediente en el sistema.
     *
     * @param ingredienteActualizado El objeto que contiene los nuevos datos del
     * ingrediente.
     * @return El ingrediente con el stock actualizado.
     * @throws NegocioException Si el stock es inválido o está vacío.
     */
    @Override
    public Ingrediente actualizar(ActualizarStockIngredienteDTO ingredienteActualizado) throws NegocioException {
        if (ingredienteActualizado.getStock() == null) {
            throw new NegocioException("El stock no puede estar vacío");

        }
        if (ingredienteActualizado.getStock() < 0) {
            throw new NegocioException("El stock no puede ser menor a 0");
        }

        return this.ingredientesDAO.agregarStock(ingredienteActualizado);
    }

}
