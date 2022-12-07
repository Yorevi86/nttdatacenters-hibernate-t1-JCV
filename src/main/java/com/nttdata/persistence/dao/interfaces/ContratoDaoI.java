/**
 * 
 */
package com.nttdata.persistence.dao.interfaces;

import java.util.List;

import com.nttdata.persistence.entities.Contrato;

/**
 * DAO de la tabla CONTRATO
 * 
 * @author Jonatan Carrera Viera
 *
 */
public interface ContratoDaoI extends CommonDaoI<Contrato>{

	/**
	 * Obtiene los contratos asociados a un clienteId.
	 * 
	 * @param clienteId
	 * @return List<Contrato>
	 */
	public List<Contrato> buscarContratosPorClienteId(final Long clienteId);

}
