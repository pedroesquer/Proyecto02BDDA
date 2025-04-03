package itson.sistemarestaurantepersistencia;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import java.util.List;

/**
 *
 * @author juanpheras
 */
public interface IProductosDAO {
    public abstract Producto registrar(NuevoProductoDTO nuevoProductoDTO);
    
    public abstract List<Producto> consultar(String filtroBusqueda);
}
