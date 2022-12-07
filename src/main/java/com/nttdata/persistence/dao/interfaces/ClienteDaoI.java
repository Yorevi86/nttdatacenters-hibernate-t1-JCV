/**
 * 
 */
package com.nttdata.persistence.dao.interfaces;

import java.util.List;

import com.nttdata.persistence.entities.Cliente;
import com.nttdata.persistence.entities.RankingGastos;

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
	 * Obtiene una lista de los clientes que más gastan.
	 * 
	 * @return List<RankingGastos>
	 */
	public List<RankingGastos> obtenerLosClientesQueMasGastan();
	
}