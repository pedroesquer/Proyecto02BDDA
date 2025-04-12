package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Mesa;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public interface IMesasDAO {
    public abstract void precargarMesas();
    
    public abstract List<Mesa> consultarMesas();
    
    public Mesa consultarMesaPorNombre(String numeroMesa);
}
