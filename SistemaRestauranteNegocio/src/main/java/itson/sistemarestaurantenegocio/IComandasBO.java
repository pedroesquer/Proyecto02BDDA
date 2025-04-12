package itson.sistemarestaurantenegocio;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public interface IComandasBO {
    public abstract Comanda crearComanda(NuevaComandaDTO nuevaComandaDTO) throws NegocioException;
    
    public abstract Comanda cerrarComanda(Long idComanda) throws NegocioException;
    
    public abstract Comanda cancelarComanda(Long idComanda) throws NegocioException;
    
    public abstract List<Comanda> consultar() throws NegocioException; 
    
}
