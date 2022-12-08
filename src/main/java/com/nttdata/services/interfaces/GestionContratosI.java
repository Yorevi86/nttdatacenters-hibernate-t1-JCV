/**
 * 
 */
package com.nttdata.services.interfaces;

import java.util.List;

import com.nttdata.persistence.entities.Contrato;

/**
 * Interfaz para la gestión de contratos.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public interface GestionContratosI {

	/**
	 * Método para obtener todos los contratos.
	 * 
	 * @return List<Contrato>
	 */
	public List<Contrato> obtenerTodosContratos();
	
	/**
	 * Método para buscar un contrato por ID.
	 * 
	 * @param contratoId
	 */
	public Contrato buscarPorId(final Long contratoId);
	
	/**
	 * Método para insertar un contrato.
	 * 
	 * @param contratoNuevo
	 */
	public void insertarNuevoContrato(final Contrato contratoNuevo);
	
	/**
	 * Método para eliminar un contrato.
	 * 
	 * @param contratoABorrar
	 */
	public void eliminarContrato(final Contrato contratoABorrar);
	
	/**
	 * Método para actualizar un contrato
	 * 
	 * @param contratoAActualizar
	 */
	public void actualizarContrato(final Contrato contratoAActualizar);
	
	/**
	 * Método para obtener los contratos asignados a un cliente.
	 * 
	 * @param clienteId
	 * @return List<Contrato>
	 */
	public List<Contrato> obtenerContratosDeUnCliente(final Long clienteId);
	
}
