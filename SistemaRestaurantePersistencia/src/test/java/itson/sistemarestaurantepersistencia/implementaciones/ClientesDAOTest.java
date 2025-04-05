/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package itson.sistemarestaurantepersistencia.implementaciones;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class ClientesDAOTest {

    private ClientesDAO clientesDAO;

    public ClientesDAOTest() {
    }

    @BeforeEach
    public void setUp() {
        clientesDAO = new ClientesDAO();
    }


    /**
     * Test registrar metodo de clase ClientesDAO.
     */
    @Test
    public void testRegistrarClienteOk() {
        // Crear un nuevo cliente con datos validos
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
                "Ana",
                "Garcia",
                "Lopez",
                "ana.garcia@example.com",
                "6441234567",
                new Date()
        );

        // Registrar el cliente
        Cliente cliente = clientesDAO.registrar(nuevoCliente);

        // Verificar que el cliente se registro correctamente
        assertNotNull(cliente.getId());
        assertEquals(nuevoCliente.getNombre(), cliente.getNombre());
        assertEquals(nuevoCliente.getApellidoPaterno(), cliente.getApellidoPaterno());
        assertEquals(nuevoCliente.getApellidoMaterno(), cliente.getApellidoMaterno());
        assertEquals(nuevoCliente.getCorreo(), cliente.getCorreo());
        assertEquals(nuevoCliente.getNumeroTelefono(), cliente.getNumeroTelefono());
        assertEquals(0.0, cliente.getPuntosFidelidad()); // Inicializado en 0
        assertEquals(0, cliente.getNumeroVisitas()); // Inicializado en 0
        assertEquals(0.0, cliente.getTotalGastado()); // Inicializado en 0

        // Limpiar: Eliminar el cliente registrado 
        clientesDAO.eliminar(cliente.getId());
    }

    @Test
    public void testRegistrarClienteSinNombre() {
        // Crear un nuevo cliente con nombre nulo
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
                null, // nombre
                "Garcia",
                "Lopez",
                "ana.garcia@example.com",
                "6441234567",
                new Date()
        );

        // Verificar que se lanza una excepcion al intentar registrar
        Exception ex = assertThrows(Exception.class, () -> clientesDAO.registrar(nuevoCliente));
    }

    @Test
    public void testRegistrarClienteSinApellidoPaterno() {
        // Crear un nuevo cliente con apellido paterno nulo
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
                "Ana",
                null, // es el apellido paterno
                "Lopez",
                "ana.garcia@example.com",
                "6441234567",
                new Date()
        );

        // Verificar que se lanza una excepcion al intentar registrar
        Exception ex = assertThrows(Exception.class, () -> clientesDAO.registrar(nuevoCliente));
    }

    @Test
    public void testRegistrarClienteSinApellidoMaterno() {
        // Crear un nuevo cliente con apellido materno nulo
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
                "Ana",
                "Garcia",
                null, // es el apellido materno
                "ana.garcia@example.com",
                "6441234567",
                new Date()
        );

        // Verificar que se lanza una excepcion al intentar registrar
        Exception ex = assertThrows(Exception.class, () -> clientesDAO.registrar(nuevoCliente));
    }

    @Test
    public void testActualizarClienteOk() {
        // Primero registrar un cliente
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
                "Carlos",
                "Perez",
                "Rodriguez",
                "carlos.perez@example.com",
                "6449876543",
                new Date()
        );
        Cliente cliente = clientesDAO.registrar(nuevoCliente);

        // Modificar algunos datos del cliente
        cliente.setNombre("Carlos Alberto");
        cliente.setCorreo("carlos.alberto@example.com");
        cliente.setPuntosFidelidad(500.0);
        cliente.setNumeroVisitas(10);
        cliente.setTotalGastado(1500.0);

        // Actualizar el cliente
        Cliente clienteActualizado = clientesDAO.actualizar(cliente);

        // Verificar que los datos se actualizaron correctamente
        assertEquals("Carlos Alberto", clienteActualizado.getNombre());
        assertEquals("carlos.alberto@example.com", clienteActualizado.getCorreo());
        assertEquals(500.0, clienteActualizado.getPuntosFidelidad());
        assertEquals(10, clienteActualizado.getNumeroVisitas());
        assertEquals(1500.0, clienteActualizado.getTotalGastado());

        // Limpiar
        clientesDAO.eliminar(cliente.getId());
    }

    @Test
    public void testConsultarClientesFiltroBusqueda() {
        // Consultar clientes con un filtro de busqueda 
        List<Cliente> clientes = clientesDAO.consultar("Juan");

        // Verificar que la lista no sea nula
        assertNotNull(clientes);

        // Se esperan 2 clientes  
        final int resultadoEsperado = 2;
        assertEquals(resultadoEsperado, clientes.size());
    }

    @Test
    public void testConsultarClientePorCorreoOk() {
        // Primero registrar un cliente
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
                "Laura",
                "Martinez",
                "Lopez",
                "laura.martinez@example.com",
                "6445551234",
                new Date()
        );
        Cliente clienteRegistrado = clientesDAO.registrar(nuevoCliente);

        // Buscar el cliente por correo
        Cliente clienteEncontrado = clientesDAO.consultarClientePorCorreo("laura.martinez@example.com");

        // Verificar que se encontro el cliente
        assertNotNull(clienteEncontrado);
        assertEquals(clienteRegistrado.getId(), clienteEncontrado.getId());
        assertEquals("laura.martinez@example.com", clienteEncontrado.getCorreo());

        // Limpiar
        clientesDAO.eliminar(clienteRegistrado.getId());
    }

    @Test
    public void testConsultarClientePorCorreoNoExistente() {
        // Buscar un cliente con un correo que no existe
        Cliente clienteEncontrado = clientesDAO.consultarClientePorCorreo("noexiste@example.com");

        // Verificar que no se encontro el cliente
        assertNull(clienteEncontrado);
    }

    @Test
    public void testBuscarPorIdOk() {
        // Primero, registrar un cliente
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
                "Sofia",
                "Hernandez",
                "Diaz",
                "sofia.hernandez@example.com",
                "6442223333",
                new Date()
        );
        Cliente clienteRegistrado = clientesDAO.registrar(nuevoCliente);

        // Buscar el cliente por ID
        Cliente clienteEncontrado = clientesDAO.buscarPorId(clienteRegistrado.getId());

        // Verificar que se encontro el cliente
        assertNotNull(clienteEncontrado);
        assertEquals(clienteRegistrado.getId(), clienteEncontrado.getId());
        assertEquals("Sofia", clienteEncontrado.getNombre());

        // Limpiar
        clientesDAO.eliminar(clienteRegistrado.getId());
    }

    @Test
    public void testBuscarPorIdNoExistente() {
        // Buscar un cliente con un ID que no existe
        Cliente clienteEncontrado = clientesDAO.buscarPorId(9999L);

        // Verificar que no se encontro el cliente
        assertNull(clienteEncontrado);
    }
}