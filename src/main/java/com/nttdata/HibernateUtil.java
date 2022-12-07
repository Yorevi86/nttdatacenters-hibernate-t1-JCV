package com.nttdata;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de configuración
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class HibernateUtil {

	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);
	
	/** Factoría de sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Constructor privado.
	 */
	private HibernateUtil() {

	}

	/**
	 * Generación de factoría de sesiones.
	 */
	static {

		try {

			// Generación de configuración.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
			LOG.info("Configuración de la sesión iniciada correctamente.");

		} catch (final Exception ex) {

			// Error de inicialización.
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			LOG.error("Error de inicialización en la configuración de la sesión.");
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Retorna la factoría de sesiones.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		
		LOG.debug("Entrada a método getSessionFactory()");
		return SESSION_FACTORY;
	}

}
