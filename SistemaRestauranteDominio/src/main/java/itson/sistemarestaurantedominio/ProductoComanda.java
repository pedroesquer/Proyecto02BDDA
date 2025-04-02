/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantedominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Soto
 */
@Entity
@Table(name = "productos_comandas")
public class ProductoComanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_productosComandas")
    private Long id;
    
    //Marcamos nullable true ya que es opcional
    @Column(name = "comentarios", length = 50, nullable = true)
    private String comentarios;
    
    @Column(name = "precio_unitario", nullable = false)
    private Float precioUnitario;
    
    @Column(name = "Cantidad", nullable = false)
    private Integer cantidad;
    
    @Column(name = "Importe", nullable = false)
    private Float importe;
    
    @ManyToOne()
    @JoinColumn(
        name = "id_comanda",
        nullable = false    
    )
    private Comanda comanda;
    
    @ManyToOne()
    @JoinColumn(
        name = "id_producto",
        nullable = false    
    )
    private Producto producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductoComanda() {
    }

    public ProductoComanda(String comentarios, Float precioUnitario, Integer cantidad, Comanda comanda, Producto producto) {
        this.comentarios = comentarios;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.importe =  (cantidad * precioUnitario);
        this.comanda = comanda;
        this.producto = producto;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        if (!(object instanceof ProductoComanda)) {
            return false;
        }
        ProductoComanda other = (ProductoComanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itson.sistemarestaurantedominio.ProductoComanda[ id=" + id + " ]";
    }
    
}
