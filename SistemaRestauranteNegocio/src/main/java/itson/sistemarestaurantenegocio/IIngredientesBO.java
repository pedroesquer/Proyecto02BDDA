/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface IIngredientesBO {
    public abstract Ingrediente registrar(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException;
    
    public abstract List<Ingrediente> consultar(String filtroBusqueda) throws NegocioException;
}
