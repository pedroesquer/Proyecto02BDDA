
package itson.sistemarestaurantedominio.dtos;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantedominio.Producto;

/**
 *Clase que representa un DTO para agregar un producto  a una comanda  ya existente.
 * 
 * Esta clase incluye los detalles del productoComanda ademas de la comanda a la cual se quiere vincular.
 * @author Juan Heras, Pedro Esquer, 
 */
public class AgregarProductoComandaDTO {
    private Long idProductoComanda;
    private String comentario;
    private Integer cantidad;
    private Float precioUnitario;
    private Float importe;
    private Long idProducto;
    private Long idComanda;

    public AgregarProductoComandaDTO() {}

    /**
     * Obtiene el ID único del producto en la comanda.
     * @return ID del producto comanda.
     */
    public Long getIdProductoComanda() {
        return idProductoComanda;
    }

    /**
     * Establece el ID del producto comanda.
     * @param idProductoComanda ID a asignar.
     */
    public void setIdProductoComanda(Long idProductoComanda) {
        this.idProductoComanda = idProductoComanda;
    }

    /**
     * Obtiene el comentario adicional relacionado con el producto.
     * @return Comentario del producto.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Establece un comentario para el producto.
     * @param comentario Texto del comentario.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtiene la cantidad del producto a agregar.
     * @return Cantidad del producto.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto.
     * @param cantidad Cantidad a asignar.
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el precio unitario del producto.
     * @return Precio unitario.
     */
    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Establece el precio unitario del producto.
     * @param precioUnitario Precio unitario a asignar.
     */
    public void setPrecioUnitario(Float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Obtiene el importe total por la cantidad del producto.
     * @return Importe total.
     */
    public Float getImporte() {
        return importe;
    }

    /**
     * Establece el importe total del producto.
     * @param importe Importe a asignar.
     */
    public void setImporte(Float importe) {
        this.importe = importe;
    }

    /**
     * Obtiene el ID del producto.
     * @return ID del producto.
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el ID del producto.
     * @param idProducto ID del producto a asignar.
     */
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el ID de la comanda a la que pertenece este producto.
     * @return ID de la comanda.
     */
    public Long getIdComanda() {
        return idComanda;
    }

    /**
     * Establece el ID de la comanda.
     * @param idComanda ID de la comanda a asignar.
     */
    public void setIdComanda(Long idComanda) {
        this.idComanda = idComanda;
    }
        
}
