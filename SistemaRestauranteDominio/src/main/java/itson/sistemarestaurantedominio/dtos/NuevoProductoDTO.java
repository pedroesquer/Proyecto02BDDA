package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.TipoProducto;
import java.util.List;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class NuevoProductoDTO {
    private String nombre;
    private Float precio;
    private TipoProducto tipo;

    public NuevoProductoDTO(String nombre, Float precio, TipoProducto tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public TipoProducto getTipo() {
        return tipo;
    }
    
}
