
package itson.sistemarestaurantepresentacion.beans;

import java.util.Date;

/**
 *
 * @author juanpheras
 */
public class ComandaDetails {
    
    private String folio;
    private Date fecha;
    private String estado;
    private String mesa;
    private String cliente;
    private double total;

    public ComandaDetails() {
    }

    public ComandaDetails(String folio, Date fecha, String estado, String mesa, String cliente, double total) {
        this.folio = folio;
        this.fecha = fecha;
        this.estado = estado;
        this.mesa = mesa;
        this.cliente = cliente;
        this.total = total;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
}
