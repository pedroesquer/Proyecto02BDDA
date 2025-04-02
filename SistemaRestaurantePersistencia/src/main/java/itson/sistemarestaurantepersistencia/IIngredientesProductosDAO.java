/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.IngredienteProducto;
import itson.sistemarestaurantedominio.dtos.NuevaRelacionIngredienteProductoDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;

/**
 *
 * @author juanpheras
 */
public interface IIngredientesProductosDAO  {
    
   public abstract IngredienteProducto registrar(NuevaRelacionIngredienteProductoDTO relacionIngredienteProductoDTO) throws PersistenciaException;
    
}
