package itson.sistemarestaurantedominio.dtos;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class ActualizarStockIngredienteDTO {
    private Long id;
    private Integer stock;

    public ActualizarStockIngredienteDTO(Long id, Integer stock) {
        this.id = id;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }
    
    
    
}
