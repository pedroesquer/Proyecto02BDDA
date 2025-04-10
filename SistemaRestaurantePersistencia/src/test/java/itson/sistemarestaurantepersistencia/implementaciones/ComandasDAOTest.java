/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.EstadoComanda;
import itson.sistemarestaurantedominio.EstadoMesa;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pedro
 */
public class ComandasDAOTest {

    public ComandasDAOTest() {
    }

    /**
     * Test of registrar method, of class ComandasDAO.
     */
    @Test
    public void testRegistrar() {
        ComandasDAO comandasDAO = new ComandasDAO();
        NuevaComandaDTO nuevaComanda = new NuevaComandaDTO();

        nuevaComanda.setFolio("OB-20250409-001");
        nuevaComanda.setMontoTotal(0D);
        nuevaComanda.setFechaHora(LocalDateTime.now());
        nuevaComanda.setEstadoComanda(EstadoComanda.ABIERTA);

    }

}
