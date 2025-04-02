package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.UnidadMedida;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class NuevoIngredienteDTO {
    private String nombre;
    private Float stock;
    private UnidadMedida unidadMedida;

    public NuevoIngredienteDTO(String nombre, Float stock, UnidadMedida unidadMedida) {
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
    
    
}
