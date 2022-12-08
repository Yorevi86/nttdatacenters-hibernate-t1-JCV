/**
 * 
 */
package com.nttdata.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author Jonatan Carrera Viera
 *
 */
@Entity
@Table(name = "T_CLIENTE")
public class Cliente extends AbstractEntity implements Serializable{

	/** Serial */
	private static final long serialVersionUID = 1L;

	/** PK */
	private Long clienteId;
	
	/** Nombre del cliente */
	private String nombre;
	
	/** Primer apellido del cliente */
	private String primerApellido;
	
	/** Segundo apellido del cliente */
	private String segundoApellido;
	
	/** Documento de identificación del cliente - Único, no nulo y hasta 9 caracteres*/
	private String documentoIdentidad;
	
	/** Lista de contratos asociados al cliente */
	private List<Contrato> listaContratos;
	
	/**
	 * @return the clienteId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_PK_CLIENTE_ID", nullable = false)
	public Long getClienteId() {
		return clienteId;
	}

	/**
	 * @param clienteId the clienteId to set
	 */
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * @return the nombre
	 */
	@Column(name = "C_NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the primerApellido
	 */
	@Column(name = "C_PRIMER_APELLIDO", nullable = false)
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * @param primerApellido the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * @return the segundoApellido
	 */
	@Column(name = "C_SEGUNDO_APELLIDO", nullable = false)
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * @param segundoApellido the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * @return the documentoIdentidad
	 */
	@Column(name = "C_DOCUMENTO_IDENTIDAD", unique = true, nullable = false, length = 9)
	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	/**
	 * @param documentoIdentidad the documentoIdentidad to set
	 */
	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	/**
	 * @return the listaContratos
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
	public List<Contrato> getListaContratos() {
		return listaContratos;
	}

	/**
	 * @param listaContratos the listaContratos to set
	 */
	public void setListaContratos(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}
	
	@Transient
	public Class<?> getClase() {
		return Contrato.class;
	}

	@Transient
	@Override
	public Long getId() {
		return this.clienteId;
	}
	
	@Transient
	@Override
	public void setId(Long id) {
		this.clienteId = id;
	}
}
