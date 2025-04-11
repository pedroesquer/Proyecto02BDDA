/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantenegocio.IComandasBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.IComandasDAO;
import itson.sistemarestaurantepersistencia.implementaciones.MesasDAO;
import itson.sistemarestaurantepersistencia.implementaciones.ProductosDAO;
import itson.sistemarestaurantedominio.EstadoMesa;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.ProductoComanda;
import java.util.List;
/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto.
 */
public class ComandasBO  implements IComandasBO{
    private IComandasDAO comandasDAO;
    private MesasDAO mesasDAO;
    private ProductosDAO productosDAO;
    
    public ComandasBO(IComandasDAO comandasDAO, MesasDAO mesasDAO, ProductosDAO productosDAO){
        this.comandasDAO=comandasDAO;
        this.mesasDAO=mesasDAO;
        this.productosDAO=productosDAO;
    }
    
    public void crearComanda(NuevaComandaDTO nuevaComandaDTO) throws NegocioException{
        try{
            Mesa mesa = nuevaComandaDTO.getMesa();
            if(mesa == null){
                throw new NegocioException("La mesa no debe ser nula.");
            }
            if(mesa.getEstado() != EstadoMesa.DISPONIBLE){
                throw new NegocioException("Mesa ocupada.");
            }
            List<ProductoComanda> productos = nuevaComandaDTO.getProductoComanda();
            if(productos==null || productos.isEmpty()){
                throw new NegocioException("La comanda debe tener al menos un producto.");
            }  
        } catch (Exception ex){
            throw new NegocioException("Error al crear la comanda: " + ex.getMessage());
        }
    }
    
}
