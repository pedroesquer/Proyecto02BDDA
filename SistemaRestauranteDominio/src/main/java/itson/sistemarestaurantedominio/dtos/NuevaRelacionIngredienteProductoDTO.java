package itson.sistemarestaurantedominio.dtos;

/**
 *
 * @author juanpheras
 */
public class NuevaRelacionIngredienteProductoDTO {
    
    private long idProducto;
    private long idIngrediente;
    private Float cantidad;

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

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
}
