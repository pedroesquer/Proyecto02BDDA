/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface IMesasBO {
    List<Mesa> consultarMesas() throws NegocioException;
}
