package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.UnidadMedida;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class NuevoIngredienteDTO {
    private Long id;
    private String nombre;
    private Float stock;
    private UnidadMedida unidadMedida;

    public NuevoIngredienteDTO(String nombre, Float stock, UnidadMedida unidadMedida) {
        this.nombre = nombre;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
    }

    public NuevoIngredienteDTO(Long id, String nombre, Float stock, UnidadMedida unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public Float getStock() {
        return stock;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public Long getId() {
        return id;
    }
    
    
    
    
}
