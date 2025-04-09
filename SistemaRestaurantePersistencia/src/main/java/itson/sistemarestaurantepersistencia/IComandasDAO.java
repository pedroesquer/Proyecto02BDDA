package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;

/**
 *
 * @author pedro
 */
public interface IComandasDAO {
    public abstract Comanda registrar(NuevaComandaDTO nuevaComanda);
}
