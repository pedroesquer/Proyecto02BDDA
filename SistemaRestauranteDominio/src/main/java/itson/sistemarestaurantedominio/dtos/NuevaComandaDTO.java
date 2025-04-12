package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.EstadoComanda;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.ProductoComanda;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class NuevaComandaDTO {
    private Long id;
    private LocalDateTime fechaHora;
    private Double montoTotal;
    private EstadoComanda estadoComanda;
    private List<ProductoComanda> productoComanda;
    private Mesa mesa;
    private Cliente cliente;

    public NuevaComandaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public EstadoComanda getEstadoComanda() {
        return estadoComanda;
    }

    public void setEstadoComanda(EstadoComanda estadoComanda) {
        this.estadoComanda = estadoComanda;
    }

    public List<ProductoComanda> getProductoComanda() {
        return productoComanda;
    }

    public void setProductoComanda(List<ProductoComanda> productoComanda) {
        this.productoComanda = productoComanda;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
    
    
    
    
    
}
