/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.EstadoComanda;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantenegocio.IComandasBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.excepciones.CantidadInexistenteException;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Soto.
 */
public class ComandasBO implements IComandasBO {

    private IComandasDAO comandasDAO;
    private static final int LIMITE_CARACTERES_NOMBRE = 50;

    private static final int LIMITE_FILTRO_BUSQUEDA = 50;

    public ComandasBO(IComandasDAO comandasDAO) {
        this.comandasDAO = comandasDAO;
    }

    @Override
    public List<Comanda> consultar() throws NegocioException {
        if (comandasDAO.consultarComanda().isEmpty()) {
            throw new NegocioException("No existen comandas abiertas por el momento");
        }
        return comandasDAO.consultarComanda();
    }

    @Override
    public Comanda crearComanda(NuevaComandaDTO nuevaComandaDTO) throws NegocioException, PersistenciaException {
        if (nuevaComandaDTO.getProductoComanda() == null) {
            throw new NegocioException("Debes proporcionar un nombre para el producto");
        }

        return this.comandasDAO.registrar(nuevaComandaDTO);
    }

    @Override
    public Comanda cerrarComanda(Long idComanda) throws NegocioException, PersistenciaException, CantidadInexistenteException {
        if (idComanda == null) {
            throw new NegocioException("La comanda no existe");
        }
        if (comandasDAO.consultarComandaIndividual(idComanda).getEstado() == EstadoComanda.CERRADA) {
            throw new NegocioException("La comanda ya está cerrada");
        }
        return this.comandasDAO.cerrarComanda(idComanda);
    }

    @Override
    public Comanda cancelarComanda(Long idComanda) throws NegocioException, PersistenciaException, CantidadInexistenteException {
        if (idComanda == null) {
            throw new NegocioException("La comanda no existe");
        }
        if (comandasDAO.consultarComandaIndividual(idComanda).getEstado() == EstadoComanda.CERRADA) {
            throw new NegocioException("La comanda ya está cerrada");
        }
        return this.comandasDAO.cerrarComanda(idComanda);
    }

    @Override
    public List<Comanda> buscarPorRangoFechas(Date desde, Date hasta) {
        return this.comandasDAO.buscarPorRangoFechas(desde, hasta);
    }

}
