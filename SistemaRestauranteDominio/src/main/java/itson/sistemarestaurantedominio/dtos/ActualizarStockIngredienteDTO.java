package itson.sistemarestaurantedominio.dtos;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class ActualizarStockIngredienteDTO {
    private Long id;
    private Float stock;

    public ActualizarStockIngredienteDTO(Long id, Float stock) {
        this.id = id;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public Float getStock() {
        return stock;
    }
    
    
    
}
