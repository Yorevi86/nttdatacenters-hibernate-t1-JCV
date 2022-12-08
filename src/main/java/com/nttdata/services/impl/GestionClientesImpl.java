/**
 * 
 */
package com.nttdata.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.persistence.dao.impl.ClienteDaoImpl;
import com.nttdata.persistence.dao.interfaces.ClienteDaoI;
import com.nttdata.persistence.entities.Cliente;
import com.nttdata.services.interfaces.GestionClientesI;

/**
 * Implementación del servicio de gestión de cliente.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class GestionClientesImpl implements GestionClientesI {

	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(GestionClientesImpl.class);
	
	/** DAO de la tabla T_CLIENTES */
	private ClienteDaoI clientelaDao;
	
	/**
	 * Método constructor.
	 */
	public GestionClientesImpl(final Session sesion) {
		this.clientelaDao = new ClienteDaoImpl(sesion);
	}
	
	@Override
	public void insertarNuevoCliente(final Cliente nuevoCliente) {

		LOG.info("Used the method insertarNuevoCliente.");
		
		// Verificación de nulidad e inexistencia.
		if (nuevoCliente != null && nuevoCliente.getClienteId() == null) {

			// Inserción del nuevo cliente.
			clientelaDao.insertar(nuevoCliente);
		}

	}
	
	@Override
	public List<Cliente> obtenerTodosClientes() {
		
		LOG.info("Used the method obtenerTodosClientes.");
		
		// Resultado.
		List<Cliente> listadoClientes;

		// Obtención de la lista de clientes.
		listadoClientes = clientelaDao.buscarTodos();

		return listadoClientes;
	}

	@Override
	public Cliente buscarPorId(Long clienteId) {
		
		LOG.info("Used the method buscarPorId for the clientID: {}", clienteId);
		
		// Resultado.
		Cliente cliente = null;

		// Verificación de nulidad.
		if (clienteId != null) {

			// Obtención del cliente por el ID.
			cliente = clientelaDao.buscarPorId(clienteId);
		}

		return cliente;
	}

	@Override
	public void eliminarCliente(Cliente clienteABorrar) {
		
		// Verificación de nulidad y existencia.
		if (clienteABorrar != null && clienteABorrar.getClienteId() != null) {
			
			LOG.warn("Used the method eliminarCliente for the clientID: {}", clienteABorrar.getClienteId());

			// Eliminación del cliente.
			clientelaDao.borrar(clienteABorrar);
		}
		
	}

	@Override
	public void actualizarCliente(Cliente clienteAActualizar) {
		
		// Verificación de nulidad y existencia.
		if (clienteAActualizar != null && clienteAActualizar.getClienteId() != null) {
			
			LOG.warn("Used the method actualizarCliente for the clientID: {}", clienteAActualizar.getClienteId());

			// Actualización de datos del cliente.
			clientelaDao.actualizar(clienteAActualizar);;
		}
		
	}

	@Override
	public List<Cliente> buscarPorNombreYApellidos(String nombre, String primerApellido, String segundoApellido) {

		LOG.info("Used the method buscarPorNombreYApellidos for name, middlename, lastname: {}, {}, {}", nombre, primerApellido, segundoApellido);
		
		// Obtención de la lista de clientes que cumplen los criterios de búsqueda.
		return clientelaDao.buscarPorNombreYApellidos(nombre, primerApellido, segundoApellido);
	}
	
	@Override
	public void obtenerLosClientesQueMasGastan() {

		LOG.info("Used the method obtenerLosClientesQueMasGastan.");
		
		// Obtención de la lista de clientes que más gastan al mes.
		clientelaDao.obtenerLosClientesQueMasGastan();
	}

}
