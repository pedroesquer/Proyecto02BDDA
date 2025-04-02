/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantedominio;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
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
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Soto
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

    @Column(name = "numero_telefono", length = 50)
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
    
    //clave secreta fija para AES que es de 16 bytes
    // la clave tiene que ser de 16, 24 o 32 caracteres
    private static final String CLAVE_SECRETA = "ClaveSecreta1234";
    

    public Cliente() {
    }

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String numeroTelefono, Date fechaRegistro, double puntosFidelidad, int numeroVisitas, double totalGastado) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.setNumeroTelefono(numeroTelefono);
        this.fechaRegistro = fechaRegistro;
        this.puntosFidelidad = puntosFidelidad;
        this.numeroVisitas = numeroVisitas;
        this.totalGastado = totalGastado;
    }
    
    // encriptar con AES
    private String encriptar(String telefono){
        try{
            SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, clave);
            byte[] encriptado = cipher.doFinal(telefono.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encriptado);
        } catch (Exception e){
            System.out.println("Error al encriptar: " + e.getMessage());
            return telefono;
        }
    }
    
    // desencriptar con AES
    private String desencriptar(String telefonoEncriptado){
        try{
            SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, clave);
            byte[] desencriptado = cipher.doFinal(Base64.getDecoder().decode(telefonoEncriptado));
            return new String(desencriptado, "UTF-8");
        } catch (Exception e){
            System.out.println("Error al desencriptar: " + e.getMessage());
            return telefonoEncriptado;
            // si no jala, devuelve encriptado
        }
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
        return desencriptar(this.numeroTelefono);
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = encriptar(numeroTelefono);
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
