/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantepersistencia.IClientesDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author victoria
 */

/**
 * Registra nuevo cliente  en la base de datos
 * @param nuevoCliente datos del nuevo cliente
 * @return cliente frecuente ya registrado
 */

public class ClientesDAO implements IClientesDAO {
    @Override
    public Cliente registrar(NuevoClienteDTO nuevoCliente){
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = new Cliente(
                nuevoCliente.getNombre(),
                nuevoCliente.getApellidoPaterno(),
                nuevoCliente.getApellidoMaterno(),
                nuevoCliente.getCorreo(),
                nuevoCliente.getNumeroTelefono(),
                nuevoCliente.getFechaRegistro()
        );
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        return cliente;
    } 
    
    /**
     * Elimina un cliente por su id
     * @param idCliente id del cliente que se va a eliminar
     */
    public void eliminar(Long idCliente){
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, idCliente);
        if(cliente!=null){
            entityManager.remove(cliente);
        }
        entityManager.getTransaction().commit();
    }
    
    /**
     * Consulta lista de clientes segun filtro de busqueda
     * @param filtroBusqueda texto a buscar en nombre / apellido
     * @return lista de clientes frecuentes que coincidan
     */
    @Override
    public List<Cliente> consultar(String filtroBusqueda){
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);
        
        if (filtroBusqueda == null || filtroBusqueda.trim().isEmpty()) {
                criteriaQuery.select(root);
            } else {
                String filtro = "%" + filtroBusqueda.toLowerCase() + "%";
                Expression<String> nombreCompleto = criteriaBuilder.concat(
                        criteriaBuilder.concat(
                                criteriaBuilder.lower(root.get("nombre")),
                                " "
                        ),
                        criteriaBuilder.concat(
                                criteriaBuilder.lower(root.get("apellidoPaterno")),
                                criteriaBuilder.concat(
                                        " ",
                                        criteriaBuilder.lower(criteriaBuilder.coalesce(root.get("apellidoMaterno"), ""))
                                )
                        )
                );
        
        Predicate condicionNombreCompleto = criteriaBuilder.like(nombreCompleto, filtro);
        Predicate condicionCorreo = criteriaBuilder.like(criteriaBuilder.lower(root.get("correo")), filtro);
        Predicate condicionFinal = criteriaBuilder.or(condicionNombreCompleto, condicionCorreo);

                criteriaQuery.where(condicionFinal);
            }

            TypedQuery<Cliente> query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();
    }
    
    /**
     * Busca un cliente por id
     * @param id del cliente que se quiere buscar
     * @return cliente encontrado / null si no existe
     */
    public Cliente buscarPorId(Long id){
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        return entityManager.find(Cliente.class, id);
    }
    
    /**
     * Actualiza cliente que ya existe en la base de datos
     * @param cliente - Cliente con datos actualizados
     * @return cliente actualizado
     */
    public Cliente actualizar(Cliente cliente){
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        entityManager.getTransaction().begin();
        Cliente clienteActualizado = entityManager.merge(cliente);
        return clienteActualizado; 
    }

     /**
     * Busca clientes por correo electronico
     * @param correo del cliente a buscar
     * @return Cliente encontrado o null si no existe
     */
    @Override
    public Cliente consultarClienteporCorreo(String correo) {
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> root = cq.from(Cliente.class);
        cq.select(root).where(cb.equal(root.get("correo"), correo));
        TypedQuery<Cliente> query = entityManager.createQuery(cq);
        List<Cliente> resultados = query.getResultList();
        return resultados.isEmpty() ? null : resultados.get(0);
    }

}
