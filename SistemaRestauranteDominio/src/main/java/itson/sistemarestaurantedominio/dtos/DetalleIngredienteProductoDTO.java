
package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.UnidadMedida;

/**
 *
 * @author Juan Heras, Pedro Esquer, Victoria Valenzuela
 */
public class DetalleIngredienteProductoDTO {
    
    private Integer cantidad;
    private UnidadMedida unidadMedida;
    private String nombre;

        public DetalleIngredienteProductoDTO(Integer cantidad, UnidadMedida unidadMedida, String nombre) {
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
