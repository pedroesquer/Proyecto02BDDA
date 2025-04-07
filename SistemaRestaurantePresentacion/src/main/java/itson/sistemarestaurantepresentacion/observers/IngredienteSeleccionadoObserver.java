package itson.sistemarestaurantepresentacion.observers;

import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;

/**
 * Interfaz del patrón Observer que permite a las clases interesadas ser
 * notificadas cuando un jugador ha sido seleccionado desde una pantalla de
 * búsqueda o selección.
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Soto
 */
public interface IngredienteSeleccionadoObserver {

    /**
     * Método invocado cuando un ingrediente ha sido seleccionado.
     *
     * @param ingrediente el ingrediente seleccionado que será enviado al observador
     * para que realice alguna acción (por ejemplo, mostrarlo en una lista o
     * almacenarlo).
     */
    void ingredienteSeleccionado(NuevoIngredienteDTO ingrediente);
}
