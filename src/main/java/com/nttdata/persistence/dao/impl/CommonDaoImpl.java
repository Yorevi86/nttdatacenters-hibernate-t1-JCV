/**
 * 
 */
package com.nttdata.persistence.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.dao.interfaces.CommonDaoI;
import com.nttdata.persistence.entities.AbstractEntity;

/**
 * Implementación del DAO genérico.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión */
	private Session sesion;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.sesion = session;
	}

	@Override
	public void insertar(final T newEntity) {

		// Verificación de sesión abierta.
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		// Se guarda el objeto que recibe y su estado cambia a persistido.
		sesion.save(newEntity);
		sesion.flush();

		// Commit
		sesion.getTransaction().commit();
	}

	@Override
	public void actualizar(final T newEntity) {

		// Verificación de sesión abierta.
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		// Se guarda o actualiza el objeto que recibe y su estado cambia a persistido.
		sesion.saveOrUpdate(newEntity);

		// Commit
		sesion.getTransaction().commit();
	}

	@Override
	public void borrar(final T newEntity) {

		// Verificación de sesión abierta.
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		// Se borra el objeto recibido y su estado cambia a persistido.
		sesion.delete(newEntity);

		// Commit
		sesion.getTransaction().commit();
	}

	@Override
	public T buscarPorId(final Long id) {

		// Verificación de sesión abierta.
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		// Devuelve la búsqueda por PK.
		return sesion.get(this.entityClass, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> buscarTodos() {

		// Verificación de sesión abierta.
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}

		// Devuelve la búsqueda de todos los registros.
		return sesion.createQuery("FROM " + this.entityClass.getName()).list();

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
