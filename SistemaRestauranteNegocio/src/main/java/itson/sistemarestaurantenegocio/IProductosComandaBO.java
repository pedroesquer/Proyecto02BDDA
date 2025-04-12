/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.AgregarProductoComandaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface IProductosComandaBO {

    public abstract List<ProductoComanda> consultar(Long id) throws NegocioException;
    
    public abstract ProductoComanda registrar(AgregarProductoComandaDTO agregarProductoComandaDTO) throws NegocioException;

}
