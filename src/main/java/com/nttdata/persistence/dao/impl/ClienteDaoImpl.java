/**
 * 
 */
package com.nttdata.persistence.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.persistence.dao.interfaces.ClienteDaoI;
import com.nttdata.persistence.entities.Cliente;
import com.nttdata.persistence.entities.Contrato;
import com.nttdata.persistence.entities.RankingGastos;

/**
 * Implementación del DAO de la tabla CLIENTE.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {

	/** Sesión de conexión a BD */
	private Session sesion;

	/**
	 * Método constructor
	 */
	public ClienteDaoImpl(Session sesion) {
		super(sesion);
		this.sesion = sesion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarPorNombreYApellidos(final String nombre, final String primerApellido,
			final String segundoApellido) {

		// Verificación de sesión abierta.
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		// Búsqueda de clientes en función del nombre y apellidos.
		return sesion.createQuery("FROM Cliente WHERE nombre LIKE '%" + nombre + "%' AND primerApellido LIKE '%"
				+ primerApellido + "%' AND segundoApellido LIKE '%" + segundoApellido + "%'").list();
	}

	@Override
	public List<RankingGastos> obtenerLosClientesQueMasGastan() {

		// Creación de la lista de Ranking usando la clase supletoria "RankingGastos".
		List<RankingGastos> lista;
		
		// Consulta.
		final CriteriaBuilder cb = sesion.getCriteriaBuilder();
		final CriteriaQuery<RankingGastos> cquery = cb.createQuery(RankingGastos.class);
		final Root<Cliente> rootP = cquery.from(Cliente.class);
		final Join<Cliente, Contrato> pJoinT = rootP.join("contrato");

		// Consulta.
		cquery.select(cb.construct(RankingGastos.class, rootP.<Long> get("cliente"), rootP.get("documentoIdentidad"), cb.sum(pJoinT.<Float> get("precio"))));
		/**rootP.get("clienteId"), rootP.get("documentoIdentidad"), cb.sum(pJoinT.<Float> get("precio")));*/

		// Clausula Group By
		cquery.groupBy(rootP.get("clienteId"), rootP.get("documentoIdentidad"));
		
		// Ordenación descendente (mayor a menor) de gastos mensuales.
		cquery.orderBy(cb.desc(cb.sum(pJoinT.<Float> get("precio"))));

		// Ejecución de consulta.
		lista = sesion.createQuery(cquery).getResultList();
		
		return lista;
	}
}
