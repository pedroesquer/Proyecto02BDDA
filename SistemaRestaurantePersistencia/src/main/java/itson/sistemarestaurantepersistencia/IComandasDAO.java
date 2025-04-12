package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantepersistencia.excepciones.CantidadInexistenteException;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface IComandasDAO {

    public abstract Comanda registrar(NuevaComandaDTO nuevaComanda) throws PersistenciaException;

    public abstract Comanda cerrarComanda(Long idComanda) throws PersistenciaException, CantidadInexistenteException;

    public abstract Comanda cancelarComanda(Long idComanda) throws PersistenciaException;

    public abstract List<Comanda> consultarComanda();

    public abstract Comanda consultarComandaIndividual(Long idComanda);
}
