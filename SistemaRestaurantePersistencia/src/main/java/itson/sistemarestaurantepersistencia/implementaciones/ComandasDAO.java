package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.EstadoComanda;
import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;

/**
 *
 * @author pedro
 */
public class ComandasDAO implements IComandasDAO {
    
    @Override
    public Comanda registrar(NuevaComandaDTO nuevaComanda) throws PersistenciaException{
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Comanda comanda = new Comanda();
        comanda.setEstado(EstadoComanda.CERRADA);
        comanda.setFechaHora(LocalDateTime.now());
        comanda.setMesa(nuevaComanda.getMesa());
        if (!(nuevaComanda.getCliente() == null)) {
            comanda.setCliente(nuevaComanda.getCliente());
        }
        if(nuevaComanda.getProductoComanda().isEmpty() || nuevaComanda.getProductoComanda() == null){
            throw new PersistenciaException("No puedes añadir una comanda sin productos.");
                    
        }
        comanda.setProductos(nuevaComanda.getProductoComanda());
        entityManager.persist(comanda);
        entityManager.getTransaction().commit();
        return comanda;
    }
    
}
