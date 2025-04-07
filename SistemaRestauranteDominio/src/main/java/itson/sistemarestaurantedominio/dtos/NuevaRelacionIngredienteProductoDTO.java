package itson.sistemarestaurantedominio.dtos;

/**
 *
 * @author juanpheras
 */
public class NuevaRelacionIngredienteProductoDTO {
    
    private long idProducto;
    private long idIngrediente;
    private Integer cantidad;

    public NuevaRelacionIngredienteProductoDTO() {}

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
}
