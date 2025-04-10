/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pedro
 */
public class MesasDAOTest {
    
    public MesasDAOTest() {
    }

    /**
     * Test of precargarMesas method, of class MesasDAO.
     */
    @Test
    public void testPrecargarMesas() {
        MesasDAO mesasDAO = new MesasDAO();
        mesasDAO.precargarMesas();
    }
    
}
