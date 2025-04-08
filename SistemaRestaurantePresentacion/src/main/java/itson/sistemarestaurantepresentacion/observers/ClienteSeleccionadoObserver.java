/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantepresentacion.observers;

import itson.sistemarestaurantedominio.Cliente;

/**
 *
 * @author victoria
 */
public interface ClienteSeleccionadoObserver {
    /**
     * metodo invocado cuando un cliente es seleccionado
     * @param cliente - cliente seleccionado que sera enviado al observer
     * para que realce alguna accion en especifico
     */
    void clienteSeleccionado(Cliente cliente);
}
