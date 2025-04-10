package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.EstadoMesa;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantepersistencia.IMesasDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class MesasDAO implements IMesasDAO {

    @Override
    public void precargarMesas() {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        List<Mesa> mesas = List.of(
                new Mesa(EstadoMesa.DISPONIBLE, "M01"),
                new Mesa(EstadoMesa.DISPONIBLE, "M02"),
                new Mesa(EstadoMesa.DISPONIBLE, "M03"),
                new Mesa(EstadoMesa.DISPONIBLE, "M04"),
                new Mesa(EstadoMesa.DISPONIBLE, "M05"),
                new Mesa(EstadoMesa.DISPONIBLE, "M06"),
                new Mesa(EstadoMesa.DISPONIBLE, "M07"),
                new Mesa(EstadoMesa.DISPONIBLE, "M08"),
                new Mesa(EstadoMesa.DISPONIBLE, "M09"),
                new Mesa(EstadoMesa.DISPONIBLE, "M10"),
                new Mesa(EstadoMesa.DISPONIBLE, "M11"),
                new Mesa(EstadoMesa.DISPONIBLE, "M12"),
                new Mesa(EstadoMesa.DISPONIBLE, "M13"),
                new Mesa(EstadoMesa.DISPONIBLE, "M14"),
                new Mesa(EstadoMesa.DISPONIBLE, "M15"),
                new Mesa(EstadoMesa.DISPONIBLE, "M16"),
                new Mesa(EstadoMesa.DISPONIBLE, "M17"),
                new Mesa(EstadoMesa.DISPONIBLE, "M18"),
                new Mesa(EstadoMesa.DISPONIBLE, "M19"),
                new Mesa(EstadoMesa.DISPONIBLE, "M20")
        );
        for (Mesa mesa : mesas) {
            entityManager.persist(mesa);
        }
        entityManager.getTransaction().commit();
    }
    
    

}
