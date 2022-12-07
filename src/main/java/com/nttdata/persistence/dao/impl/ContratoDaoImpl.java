/**
 * 
 */
package com.nttdata.persistence.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.persistence.dao.interfaces.ContratoDaoI;
import com.nttdata.persistence.entities.Cliente;
import com.nttdata.persistence.entities.Contrato;

/**
 * Implementación del DAO de la tabla CONTRATO.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class ContratoDaoImpl extends CommonDaoImpl<Contrato> implements ContratoDaoI {

	/** Sesión de conexión a BD */
	private Session sesion;

	/**
	 * Método constructor
	 * 
	 * @param sesion
	 */
	public ContratoDaoImpl(Session sesion) {
		super(sesion);
		this.sesion = sesion;
	}

	@Override
	public List<Contrato> buscarContratosPorClienteId(final Long clienteId) {

		// Consulta.
		final CriteriaBuilder cb = sesion.getCriteriaBuilder();
		final CriteriaQuery<Contrato> cquery = cb.createQuery(Contrato.class);
		final Root<Contrato> rootP = cquery.from(Contrato.class);
		final Join<Contrato, Cliente> pJoinT = rootP.join("cliente");

		// Where.
		final Predicate pr1 = cb.equal(pJoinT.getParent().<Long> get("cliente"), clienteId);

		// Consulta.
		cquery.select(rootP).where(cb.and(pr1));

		// Ejecución de consulta.
		return sesion.createQuery(cquery).getResultList();
	}

}
