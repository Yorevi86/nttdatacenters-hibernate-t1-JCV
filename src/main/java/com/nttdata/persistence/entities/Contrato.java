/**
 * 
 */
package com.nttdata.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Jonatan Carrera Viera
 *
 */
@Entity
@Table(name = "T_CONTRATO")
public class Contrato extends AbstractEntity implements Serializable{

	/** Serial */
	private static final long serialVersionUID = 1L;
	
	/** PK */
	private Long contratoId;
	
	/** Fecha de vigencia */
	private Date fechaVigencia;
	
	/** Fecha de caducidad */
	private Date fechaCaducidad;
	
	/** Precio mensual */
	private Float precio;
	
	/** Cliente asociado FK */
	private Cliente cliente;
	
	/**
	 * @return the contratoId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_PK_CONTRATO_ID", nullable = false)
	public Long getContratoId() {
		return contratoId;
	}

	/**
	 * @param contratoId the contratoId to set
	 */
	public void setContratoId(Long contratoId) {
		this.contratoId = contratoId;
	}

	/**
	 * @return the fechaVigencia
	 */
	@Column(name = "C_FECHA_VIGENCIA", nullable = false)
	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	/**
	 * @param fechaVigencia the fechaVigencia to set
	 */
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	/**
	 * @return the fechaCaducidad
	 */
	@Column(name = "C_FECHA_CADUCIDAD", nullable = false)
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * @param fechaCaducidad the fechaCaducidad to set
	 */
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	/**
	 * @return the precio
	 */
	@Column(name = "C_PRECIO", precision = 2, nullable = false)
	public Float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	/**
	 * @return the cliente
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_FK_CLIENTE_ID", referencedColumnName = "C_PK_CLIENTE_ID")
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Transient
	public Class<?> getClase() {
		return Contrato.class;
	}

	@Transient
	@Override
	public Long getId() {
		return this.contratoId;
	}

	@Transient
	@Override
	public void setId(Long id) {
		this.contratoId = id;
	}
	
}
