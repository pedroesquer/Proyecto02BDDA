
package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.UnidadMedida;

/**
 *
 * @author Juan Heras, Pedro Esquer, Victoria Valenzuela
 */
public class DetalleIngredienteProductoDTO {
    
    private Long id;
    private Integer cantidad;
    private UnidadMedida unidadMedida;
    private String nombre;

    public DetalleIngredienteProductoDTO(Long id, Integer cantidad, UnidadMedida unidadMedida, String nombre) {
        this.id = id; 
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
