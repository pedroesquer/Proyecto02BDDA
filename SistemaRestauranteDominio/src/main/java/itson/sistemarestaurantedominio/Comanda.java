package itson.sistemarestaurantedominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Soto
 */
@Entity
@Table(name = "comandas")
public class Comanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comanda")
    private Long id;

    @Column(name = "folio", length = 20, nullable = false)
    private String folio;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "monto_total")
    private Double montoTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoComanda estado;

    @OneToMany(mappedBy = "comanda", cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
    private List<ProductoComanda> productos;
    
    @ManyToOne()
    @JoinColumn(
        name = "id_mesa",
        nullable = false
    )
    private Mesa mesa;
    
    
    @ManyToOne()
    @JoinColumn(
       name = "id_cliente",
       nullable = true
    )
    private Cliente cliente;

    public Comanda() {}

    public Comanda(Long id, String folio, LocalDateTime fechaHora, Double montoTotal, EstadoComanda estado, List<ProductoComanda> productos, Mesa mesa) {
        this.id = id;
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.montoTotal = montoTotal;
        this.estado = estado;
        this.productos = productos;
        this.mesa = mesa;
    }

    public Comanda(Long id, String folio, LocalDateTime fechaHora, Double montoTotal, EstadoComanda estado, List<ProductoComanda> productos, Mesa mesa, Cliente cliente) {
        this.id = id;
        this.folio = folio;
        this.fechaHora = fechaHora;
        this.montoTotal = montoTotal;
        this.estado = estado;
        this.productos = productos;
        this.mesa = mesa;
        this.cliente = cliente;
    }
    
    

    

    public Long getId() {
        return id;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
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

    public EstadoComanda getEstado() {
        return estado;
    }
    
    // Este método se llama antes de pasar los datos al reporte
    public String getEstadoString() {
        return estado != null ? estado.name() : "";
    }
    //Profe disculpe por estos es que la neta el JaspertReports tenia muchos problemas
    public String getMesaString(){
        return mesa.getNumeroMesa();
    }
    
    public String getClienteString(){
        if (cliente!=null)
            return cliente.getNombre() + cliente.getApellidoPaterno();
        else{
            return "-";
        }
    }


    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public List<ProductoComanda> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoComanda> productos) {
        this.productos = productos;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itson.sistemarestaurantedominio.Comanda[ id=" + id + " ]";
    }

}
