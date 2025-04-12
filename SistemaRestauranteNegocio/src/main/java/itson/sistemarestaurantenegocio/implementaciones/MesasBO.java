/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantenegocio.IMesasBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.IMesasDAO;
import java.util.List;

/**
 *
 * @author pedro
 */
public class MesasBO implements IMesasBO{
    
    private IMesasDAO mesasDAO;

    public MesasBO(IMesasDAO mesasDAO) {
        this.mesasDAO = mesasDAO;
    }
    
    
    
    
    @Override
    public List<Mesa> consultarMesas() throws NegocioException{
        if(mesasDAO.consultarMesas() == null){
            throw new NegocioException("No puede haber mesas vacias");
        }
        return this.mesasDAO.consultarMesas();
    }
    
}
