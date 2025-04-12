/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.sistemarestaurantepresentacion.observers;

import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;

/**
 *
 * @author pedro
 */
public interface ComandaSeleccionadaObserver {
    
    /**
     * Método invocado cuando un ingrediente ha sido seleccionado.
     *
     * @param comanda la comanda seleccionado que será enviado al observador
     * para que realice alguna acción (por ejemplo, mostrarlo en una lista o
     * almacenarlo).
     */
    void comandaSeleccionada(NuevaComandaDTO comanda);
}
