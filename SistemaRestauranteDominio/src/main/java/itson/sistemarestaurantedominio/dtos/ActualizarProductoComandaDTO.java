package itson.sistemarestaurantedominio.dtos;

/**
 *
 * @author pedro
 */
public class ActualizarProductoComandaDTO {

    private Long idProductoComanda;
    private Integer cantidad;

    public ActualizarProductoComandaDTO() {
    }

    public void setIdProductoComanda(Long idProductoComanda) {
        this.idProductoComanda = idProductoComanda;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdProductoComanda() {
        return idProductoComanda;
    }

    public Integer getCantidad() {
        return cantidad;
    }

}
