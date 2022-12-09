/**
 * 
 */
package com.nttdata.utilities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase para el mostrado de datos en consola.
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class Utilidades {

	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(Utilidades.class);
	
	/**Contructor */
	private Utilidades() {
		
		LOG.warn("Creation of an Utilidades class try.");
		
		throw new IllegalStateException("Clase para utilidades únicamente.");
	}
	
	/**
	 * Método para construir un texto usando StringBuilder.
	 * 
	 * @param texto
	 * @return
	 */
	public static String stringBuilder (String... texto) {
		
		LOG.debug("stringBuilder method used.");
		
		StringBuilder sb = new StringBuilder();
		
		/** For each para recorrer el texto recibido y darle forma usando StringBuilder con bajo consumo de recursos*/
		for (String aConstruir: texto) {
			sb.append(aConstruir);
		}
		
		return sb.toString();
	}
	/**
	 * Método para devolver una fecha en formato Date desde un String a un Date válido para SQL.
	 * 
	 * @param fecha
	 * @return
	 */
	public static Date formatDateForSql (String fecha) {
		
		LOG.debug("formatDateForSql method used.");
		
		/** Cambiamos del formato español al formato de Date en SQL. */
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		return  Date.valueOf(LocalDate.parse(fecha, formato).format(formato2));
	}
}
