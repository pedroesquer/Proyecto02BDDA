/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.Comanda_;
import itson.sistemarestaurantedominio.EstadoComanda;
import itson.sistemarestaurantedominio.EstadoMesa;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.ProductoComanda;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantepersistencia.excepciones.PersistenciaException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
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
    public void testRegistrarComandaOk() throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        ComandasDAO comandasDAO = new ComandasDAO();
        NuevaComandaDTO nuevaComanda = new NuevaComandaDTO();
        
        List<ProductoComanda> productos = new ArrayList<>();
        Producto producto = entityManager.find(Producto.class, 2L);
        Mesa mesa = entityManager.find(Mesa.class, 1l);
        
        ProductoComanda productoComanda = new ProductoComanda();
        productoComanda.setCantidad(2);
        productoComanda.setProducto(producto);
        productoComanda.setComentarios("Sin camaron");
        productoComanda.setPrecioUnitario(producto.getPrecio());
        productoComanda.setImporte(productoComanda.getPrecioUnitario()*productoComanda.getCantidad());
        productos.add(productoComanda);
        
        nuevaComanda.setMesa(mesa);
        nuevaComanda.setMontoTotal(0D);
        nuevaComanda.setEstadoComanda(EstadoComanda.ABIERTA);
        nuevaComanda.setProductoComanda(productos);
        
        Comanda comanda = comandasDAO.registrar(nuevaComanda);  
        assertNotNull(comanda.getId());
        
    }
    
    @Test
    public void testRegistrarComandaSinComentarios() throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        ComandasDAO comandasDAO = new ComandasDAO();
        NuevaComandaDTO nuevaComanda = new NuevaComandaDTO();
        
        List<ProductoComanda> productos = new ArrayList<>();
        Producto producto = entityManager.find(Producto.class, 2L);
        Mesa mesa = entityManager.find(Mesa.class, 1l);
        
        ProductoComanda productoComanda = new ProductoComanda();
        productoComanda.setCantidad(2);
        productoComanda.setProducto(producto);
        productoComanda.setPrecioUnitario(producto.getPrecio());
        productoComanda.setImporte(productoComanda.getPrecioUnitario()*productoComanda.getCantidad());
        productos.add(productoComanda);
        
        nuevaComanda.setMesa(mesa);
        nuevaComanda.setMontoTotal(0D);
        nuevaComanda.setEstadoComanda(EstadoComanda.ABIERTA);
        nuevaComanda.setProductoComanda(productos);
        
        Comanda comanda = comandasDAO.registrar(nuevaComanda);  
        assertNotNull(comanda.getId());
        
    }

}
