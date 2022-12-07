/**
 * 
 */
package com.nttdata.services.interfaces;

import java.util.List;

import com.nttdata.persistence.entities.Cliente;
import com.nttdata.persistence.entities.RankingGastos;

/**
 * Interfaz para la gestión de clientes.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public interface GestionClientesI {

	/**
	 * Método para obtener todos los clientes.
	 * 
	 * @return List<Cliente>
	 */
	public List<Cliente> obtenerTodosClientes();
	
	/**
	 * Método para buscar un cliente por ID.
	 * 
	 * @param clienteId
	 */
	public Cliente buscarPorId(final Long clienteId);
	
	/**
	 * Método para insertar un cliente.
	 * 
	 * @param clienteNuevo
	 */
	public void insertarNuevoCliente(final Cliente clienteNuevo);
	
	/**
	 * Método para eliminar un cliente.
	 * 
	 * @param clienteABorrar
	 */
	public void eliminarCliente(final Cliente clienteABorrar);
	
	/**
	 * Método para actualizar un cliente
	 * 
	 * @param clienteAActualizar
	 */
	public void actualizarCliente(final Cliente clienteAActualizar);
	
	/**
	 * Método para buscar clientes por nombre y apellidos.
	 * 
	 * @param nombre
	 * @param primerApellido
	 * @param segundoApellido
	 * @return List<Cliente>
	 */
	public List<Cliente> buscarPorNombreYApellidos(final String nombre, final String primerApellido, final String segundoApellido);

	/**
	 * Método para hacer una lista de los clientes que más gastan.
	 * 
	 * @return List<Cliente>
	 */
	public List<RankingGastos> obtenerLosClientesQueMasGastan();
}
