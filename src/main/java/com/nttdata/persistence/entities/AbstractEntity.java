/**
 * 
 */
package com.nttdata.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Entidad abstracta
 * 
 * @author Jonatan Carrera Viera
 *
 */

@MappedSuperclass
public abstract class AbstractEntity implements Serializable{
	
	/** LOG */
	private static final Logger LOG = LoggerFactory.getLogger(AbstractEntity.class);
	
	/** Serial */
	private static final long serialVersionUID = 1L;
	
	/** Auditoria - Creación de usuario */
	private String createUser;
	
	/** Auditoria - Fecha de creación */
	private Date createDate;
	
	/**
	 * Método genérico para obtener el ID
	 * 
	 * @return Long
	 */
	@Transient
	public abstract Long getId();
	
	/**
	 * Método genérico para añadir el ID
	 * 
	 * @param clienteId
	 */
	public abstract void setId(final Long id);

	/**
	 * @return the createUser
	 */
	@Column(name = "AUDIT_CREATE_USER", nullable = false)
	public String getCreateUser() {
		
		LOG.debug("Getting user created in AbstractEntity.");
		
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		
		LOG.info("Created user in AbstractEntity: {}", createUser);
		
		this.createUser = createUser;
	}

	/**
	 * @return the createDate
	 */
	@Column(name = "AUDIT_CREATE_DATE", nullable = false)
	public Date getCreateDate() {
		
		LOG.debug("Getting date of creation in AbstractEntity.");
		
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		
		LOG.info("Date of creation in AbstractEntity: {}", createDate);
		
		this.createDate = createDate;
	}
	
}
