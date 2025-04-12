package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.excepciones.CantidadInexistenteException;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public interface IComandasBO {
    public abstract Comanda crearComanda(NuevaComandaDTO nuevaComandaDTO) throws NegocioException, PersistenciaException;
    
    public abstract Comanda cerrarComanda(Long idComanda) throws NegocioException, PersistenciaException, CantidadInexistenteException;
    
    public abstract Comanda cancelarComanda(Long idComanda) throws NegocioException, PersistenciaException, CantidadInexistenteException;
    
    public abstract List<Comanda> consultar() throws NegocioException; 
    
    public abstract List<Comanda> buscarPorRangoFechas(Date desde, Date hasta);
    
    public abstract Comanda consultarComandaIndividual(Long id) throws NegocioException;
    
}
