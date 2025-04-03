/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author victoria
 */
public interface IClientesBO {
    public abstract Cliente registrar(NuevoClienteDTO nuevoCliente) throws NegocioException;
    public abstract List<Cliente> consultar(String filtroBusqueda) throws NegocioException;
    
    
}
