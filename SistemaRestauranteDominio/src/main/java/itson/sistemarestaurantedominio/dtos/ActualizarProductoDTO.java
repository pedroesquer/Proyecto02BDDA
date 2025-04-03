package itson.sistemarestaurantedominio.dtos;

/**
 *
 * @author juanpheras
 */
public class ActualizarProductoDTO {
    private Long id;
    private String nombre;
    private Float precio;

    public ActualizarProductoDTO() {
    }

    public ActualizarProductoDTO(Long id, String nombre, Float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;   
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
    
    
    
}
