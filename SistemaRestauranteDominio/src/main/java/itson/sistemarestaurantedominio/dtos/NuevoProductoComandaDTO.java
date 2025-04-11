package itson.sistemarestaurantedominio.dtos;

/**
 *
 * @author pedro
 */
public class NuevoProductoComandaDTO {
    private String comentario;
    private Integer cantidad;
    private Float precioUnitario;
    private Float importe;

    public NuevoProductoComandaDTO() {
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }
    
    
}
