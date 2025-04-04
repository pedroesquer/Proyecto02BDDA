/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantedominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
@Entity
@Table(name = "clientes_frecuentes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno", length = 40, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 40, nullable = false)
    private String apellidoMaterno;

    @Column(name = "correo", length = 50)
    private String correo;

    @Column(name = "numero_telefono", length = 255) // el tamano es para texto encriptado.
    private String numeroTelefono;

    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @Column(name = "puntos_fidelidad", nullable = false)
    private double puntosFidelidad;

    @Column(name = "numero_visitas", nullable = false)
    private int numeroVisitas;

    @Column(name = "total_gastado", nullable = false)
    private double totalGastado;

    @OneToMany(mappedBy = "cliente")
    private List<Comanda> comandas;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String numeroTelefono, 
                   Date fechaRegistro, double puntosFidelidad, int numeroVisitas, double totalGastado) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono; 
        this.fechaRegistro = fechaRegistro;
        this.puntosFidelidad = puntosFidelidad;
        this.numeroVisitas = numeroVisitas;
        this.totalGastado = totalGastado;
    }

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String numeroTelefono, Date fechaRegistro) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.fechaRegistro = fechaRegistro;
        this.puntosFidelidad = 0;
        this.numeroVisitas = 0;
        this.totalGastado = 0.0; //inicializado en 0 para que se calcule en la capa de negocio
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono; 
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono; 
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(double puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    public int getNumeroVisitas() {
        return numeroVisitas;
    }

    public void setNumeroVisitas(int numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }

    public double getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(double totalGastado) {
        this.totalGastado = totalGastado;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itson.sistemarestaurantedominio.Cliente[ id=" + id + " ]";
    }
}