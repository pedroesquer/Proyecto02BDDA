/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantenegocio.implementaciones;

import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.IClientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author victoria
 */
public class ClientesBO implements IClientesBO{
    private IClientesDAO clientesDAO;
    private static final int LIMITE_CARACTERES_NOMBRE = 40;
    private static final int LIMITE_CARACTERES_APELLIDO = 40;
    private static final int LIMITE_CARACTERES_CORREO = 50;
    private static final int LIMITE_CARACTERES_TELEFONO = 10;
    private static final int LIMITE_FILTRO_BUSQUEDA = 50;
    
    public ClientesBO(IClientesDAO clientesDAO){
        this.clientesDAO = clientesDAO;
    }
    
    @Override
    public ClienteFrecuente registrar(NuevoClienteDTO nuevoCliente) throws NegocioException{
        if(nuevoCliente.getNombre()==null || nuevoCliente.getNombre().isBlank()) {
            throw new NegocioException("Debe proporcionar un nombre para el cliente.");
        }
        if(nuevoCliente.getNombre().length()>LIMITE_CARACTERES_NOMBRE){
            throw new NegocioException("El nombre del cliente es demasiado largo.");
        }
        if(nuevoCliente.getApellidoPaterno()==null || nuevoCliente.getApellidoPaterno().isBlank()){
            throw new NegocioException("Debe proporcionar un apellido paterno.");
        }
        if (nuevoCliente.getApellidoPaterno().length() > LIMITE_CARACTERES_APELLIDO) {
            throw new NegocioException("El apellido paterno es demasiado largo.");
        }
        if (nuevoCliente.getApellidoMaterno() != null && nuevoCliente.getApellidoMaterno().length() > LIMITE_CARACTERES_APELLIDO) {
            throw new NegocioException("El apellido materno es demasiado largo.");
        }
        if (nuevoCliente.getCorreo() != null && nuevoCliente.getCorreo().length() > LIMITE_CARACTERES_CORREO) {
            throw new NegocioException("El correo es demasiado largo.");
        }
        if (nuevoCliente.getNumeroTelefono() != null && nuevoCliente.getNumeroTelefono().length() != LIMITE_CARACTERES_TELEFONO) {
            throw new NegocioException("El numero de telefono debe tener 10 digitos.");
        }
        if (nuevoCliente.getFechaRegistro() == null) {
            throw new NegocioException("La fecha de registro es obligatoria.");
        }
        if (nuevoCliente.getPuntosFidelidad() < 0) {
            throw new NegocioException("Los puntos de fidelidad no pueden ser negativos.");
        }
        return this.clientesDAO.registrar(nuevoCliente);
    }
    
    @Override
    public List<ClienteFrecuente> consultar(String filtroBusqueda) throws NegocioException{
       if(filtroBusqueda.length()>LIMITE_FILTRO_BUSQUEDA){
           throw new NegocioException("El filtro de busqueda es demasiado largo.");
       } 
       return this.clientesDAO.consultar(filtroBusqueda);
        
    }
    
    
    
}
