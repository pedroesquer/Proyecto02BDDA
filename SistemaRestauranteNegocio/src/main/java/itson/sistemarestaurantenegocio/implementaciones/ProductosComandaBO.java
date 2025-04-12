/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.AgregarProductoComandaDTO;
import itson.sistemarestaurantenegocio.IProductosComandaBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepersistencia.IProductosComandaDAO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import itson.sistemarestaurantepersistencia.implementaciones.ProductosComandaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class ProductosComandaBO implements IProductosComandaBO {

    IProductosComandaDAO productosComanda;

    public ProductosComandaBO(IProductosComandaDAO productosComanda) {
        this.productosComanda = productosComanda;
    }

    @Override
    public List<ProductoComanda> consultar(Long id) throws NegocioException {
        if (productosComanda.consultar(id).isEmpty()) {
            throw new NegocioException("No existen comandas abiertas por el momento");
        }
        return productosComanda.consultar(id);
    }

    @Override
    public ProductoComanda registrar(AgregarProductoComandaDTO agregarProductoComandaDTO) throws NegocioException {
        if (agregarProductoComandaDTO == null) {
            throw new NegocioException("Producto null");
        }
        try {
            return productosComanda.registrar(agregarProductoComandaDTO);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProductosComandaBO.class.getName()).log(Level.SEVERE, "Error al registrar el producto en la comanda", ex);
        }
        return null;
    }

}
