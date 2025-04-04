/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantedominio.dtos;

import java.util.Date;

/**
 *
 * @author victoria
 */
public class NuevoClienteDTO {
    private Long id;
    private String nombre; 
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String numeroTelefono;
    private Date fechaRegistro;
    private double puntosFidelidad;
    private int numeroVisitas;
    private double totalGastado;
    
    public NuevoClienteDTO(){}
    
    public NuevoClienteDTO(Long id, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String numeroTelefono, Date fechaRegistro, double puntosFidelidad, int numeroVisitas, double totalGastado ){
        this.id=id;
        this.nombre=nombre;
        this.apellidoPaterno=apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.correo=correo;
        this.numeroTelefono=numeroTelefono;
        this.fechaRegistro=fechaRegistro;
        this.puntosFidelidad=puntosFidelidad;
        this.numeroVisitas=numeroVisitas;
        this.totalGastado=totalGastado;
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

}
