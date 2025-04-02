/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pedro
 */
public class ManejadorConexiones {
    public static EntityManager getEntityManager(){
                //Solicitamos una fabrica de entity managers
        EntityManagerFactory emFactory;
        emFactory = Persistence.createEntityManagerFactory("itson_SistemaVideojuegos_jar_1.0PU");

        //La fabrica crea un entity manager = base de datos
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
}
