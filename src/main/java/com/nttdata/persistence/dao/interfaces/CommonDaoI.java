/**
 * 
 */
package com.nttdata.persistence.dao.interfaces;

import java.util.List;

/**
 * DAO genérico.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public interface CommonDaoI<T> {

	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void insertar(final T paramT);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void actualizar(final T paramT);
	
	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void borrar(final T paramT);
	
	/**
	 * Localiza un registro por ID en BBDD.
	 * 
	 * @param paramT
	 */
	public T buscarPorId(final Long id);

	/**
	 * Búsqueda de todos los registros en BBDD.
	 * 
	 * @return List<T>
	 */
	public List<T> buscarTodos();
	
}
