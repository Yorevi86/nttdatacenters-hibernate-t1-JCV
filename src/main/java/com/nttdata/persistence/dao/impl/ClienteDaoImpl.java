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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.persistence.dao.interfaces.ClienteDaoI;
import com.nttdata.persistence.entities.Cliente;
import com.nttdata.persistence.entities.Contrato;

/**
 * Implementación del DAO de la tabla CLIENTE.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {

	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(ClienteDaoImpl.class);
	
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
	public List<Cliente> buscarPorNombreYApellidos(final String nombre, final String primerApellido, final String segundoApellido) {

		LOG.info("Used the method buscarPorNombreYApellidos for the client with the following name, middlename and lastname: {}, {}, {}",nombre, primerApellido, segundoApellido);
		
		// Verificación de sesión abierta.
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		// Búsqueda de clientes en función del nombre y apellidos.
		return sesion.createQuery("FROM Cliente WHERE nombre LIKE '%" + nombre + "%' AND primerApellido LIKE '%"
				+ primerApellido + "%' AND segundoApellido LIKE '%" + segundoApellido + "%'").list();
	}

	@Override
	public void obtenerLosClientesQueMasGastan() {

		LOG.info("Used the method obtenerLosClientesQueMasGastan.");
		
		// Consulta.
		final CriteriaBuilder cb = sesion.getCriteriaBuilder();
		final CriteriaQuery<Object[]> cquery = cb.createQuery(Object[].class);
		final Root<Contrato> rootP = cquery.from(Contrato.class);
		final Join<Contrato, Cliente> pJoinT = rootP.join("cliente");

		// Consulta con las columnas a obtener.
		cquery.multiselect(pJoinT.get("clienteId"), pJoinT.get("documentoIdentidad"), cb.sum(rootP.<Float> get("precio")));

		// Cláusula Group By de las columnas a agrupar.
		cquery.groupBy(pJoinT.get("clienteId"), pJoinT.get("documentoIdentidad"));
		
		// Ordenación descendente de gastos mensuales de cada cliente con la suma de todos sus precios.
		cquery.orderBy(cb.desc(cb.sum(rootP.<Float> get("precio"))));

		// Ejecución de la consulta.
		List<Object[]> listaResultante = sesion.createQuery(cquery).getResultList();
		
		// Impresión de la lista de objetos usando un forEach con expresión lambda y asignándole un formato de impresión propio sin usar la clase Utilidades.
		listaResultante.forEach(objects -> System.out.printf("Id Cliente: %s | Documento de identidad: %s | Suma total de gastos: %s%n", objects[0], objects[1], objects[2]));
	}
}
