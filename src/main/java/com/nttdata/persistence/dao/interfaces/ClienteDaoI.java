/**
 * 
 */
package com.nttdata.persistence.dao.interfaces;

import java.util.List;

import com.nttdata.persistence.entities.Cliente;

/**
 * DAO de la tabla CLIENTE
 * 
 * @author Jonatan Carrera Viera
 *
 */
public interface ClienteDaoI extends CommonDaoI<Cliente>{

	/**
	 * Obtiene clientes por nombre y apellidos.
	 * 
	 * @param nombre
	 * @param primerApellido
	 * @param segundoApellido
	 * @return List<Cliente>
	 */
	public List<Cliente> buscarPorNombreYApellidos(final String nombre, final String primerApellido, final String segundoApellido);
	
	/**
	 * Obtiene una lista de los clientes que más gastan y la printa en consola.
	 */
	public void obtenerLosClientesQueMasGastan();
	
}