/**
 * 
 */
package com.nttdata.services.impl;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.dao.impl.ContratoDaoImpl;
import com.nttdata.persistence.dao.interfaces.ContratoDaoI;
import com.nttdata.persistence.entities.Contrato;
import com.nttdata.services.interfaces.GestionContratosI;

/**
 * Implementación del servicio de contratos.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class GestionContratosImpl implements GestionContratosI{
	
	/** DAO de la tabla T_CONTRATOS */
	private ContratoDaoI contratoDao;
	
	/**
	 * Método constructor.
	 */
	public GestionContratosImpl(final Session sesion) {
		this.contratoDao = new ContratoDaoImpl(sesion);
	}
	
	@Override
	public void insertarNuevoContrato(final Contrato nuevoContrato) {

		// Verificación de nulidad e inexistencia.
		if (nuevoContrato != null && nuevoContrato.getContratoId() == null) {

			// Inserción del nuevo contrato.
			contratoDao.insertar(nuevoContrato);
		}

	}
	
	@Override
	public List<Contrato> obtenerTodosContratos() {
		
		// Resultado.
		List<Contrato> listadoContratos;

		// Obtención de la lista de contratos.
		listadoContratos = contratoDao.buscarTodos();

		return listadoContratos;
	}

	@Override
	public Contrato buscarPorId(Long contratoId) {
		
		// Resultado.
		Contrato contrato = null;

		// Verificación de nulidad.
		if (contratoId != null) {

			// Obtención del contrato por el ID.
			contrato = contratoDao.buscarPorId(contratoId);
		}

		return contrato;
	}

	@Override
	public void eliminarContrato(Contrato contratoABorrar) {

		// Verificación de nulidad y existencia.
		if (contratoABorrar != null && contratoABorrar.getContratoId() != null) {

			// Eliminación del contrato.
			contratoDao.borrar(contratoABorrar);
		}
		
	}

	@Override
	public void actualizarContrato(Contrato contratoAActualizar) {
		
		// Verificación de nulidad y existencia.
		if (contratoAActualizar != null && contratoAActualizar.getContratoId() != null) {

			// Actualización de datos del contrato.
			contratoDao.actualizar(contratoAActualizar);
		}
		
	}

	@Override
	public List<Contrato> obtenerContratosDeUnCliente(Long clienteId) {
		
		// Obtención de la lista de contratos que cumplen los criterios de búsqueda.
		return contratoDao.buscarContratosPorClienteId(clienteId);
	}
}
