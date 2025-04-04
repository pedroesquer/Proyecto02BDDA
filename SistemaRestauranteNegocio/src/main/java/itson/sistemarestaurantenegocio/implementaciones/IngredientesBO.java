/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.IIngredientesDAO;
import java.util.List;

/**
 *
 * @author pedro
 */
public class IngredientesBO implements IIngredientesBO {

    private IIngredientesDAO ingredientesDAO;
    private static final int LIMITE_CARACTERES_NOMBRE = 50;

    private static final int LIMITE_FILTRO_BUSQUEDA = 50;

    public IngredientesBO(IIngredientesDAO ingredientesDAO) {
        this.ingredientesDAO = ingredientesDAO;
    }

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


        return this.ingredientesDAO.registrar(nuevoIngrediente);
    }

    @Override
    public List<Ingrediente> consultar(String filtroBusqueda) throws NegocioException {
        if (filtroBusqueda.length() > LIMITE_FILTRO_BUSQUEDA) {
            throw new NegocioException("El filtro de busqueda es demasiado largo");
        }
        return this.ingredientesDAO.consultarIngredientes(filtroBusqueda);
    }

}
