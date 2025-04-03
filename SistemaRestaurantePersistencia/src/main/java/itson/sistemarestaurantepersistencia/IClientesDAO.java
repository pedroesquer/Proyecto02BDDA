/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import java.util.List;

/**
 *
 * @author victoria
 */

public interface IClientesDAO {
    Cliente registrar(NuevoClienteDTO nuevoCliente);
    List<Cliente> consultar(String filtroBusqueda);
}