package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.UnidadMedida;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class NuevoIngredienteDTO {
    private Long id;
    private String nombre;
    private Integer stock;
    private UnidadMedida unidadMedida;

    public NuevoIngredienteDTO(String nombre, Integer stock, UnidadMedida unidadMedida) {
        this.nombre = nombre;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
    }

    public NuevoIngredienteDTO(Long id, String nombre, Integer stock, UnidadMedida unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public Long getId() {
        return id;
    }
    
    
    
    
}
