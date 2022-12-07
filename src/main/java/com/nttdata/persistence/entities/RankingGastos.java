/**
 * 
 */
package com.nttdata.persistence.entities;

/**
 * Clase para poder registrar un ranking de los clientes que más gastan.
 * Se ha creado para recibir el resultado de la query "obtenerLosClientesQueMasGastan()"
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class RankingGastos {
	
	//Atributo para recoger el ID del cliente.
	private Long clienteId;
	
	//Atributo para recoger el dni del cliente.
	private String documentoIdentidad;
	
	//Atributo para recoger la suma de los gastos mensuales de la cláusula Group By de la query.
	private Float sumPrecio;

	/**
	 * Método constructor
	 * 
	 * @param clienteId
	 * @param documentoIdentidad
	 * @param sumPrecio
	 */
	public RankingGastos(Long clienteId, String documentoIdentidad, Float sumPrecio) {
		super();
		this.clienteId = clienteId;
		this.documentoIdentidad = documentoIdentidad;
		this.sumPrecio = sumPrecio;
	}

	/**
	 * @return the clienteId
	 */
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
	 * @return the documentoIdentidad
	 */
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
	 * @return the sumPrecio
	 */
	public Float getSumPrecio() {
		return sumPrecio;
	}

	/**
	 * @param sumPrecio the sumPrecio to set
	 */
	public void setSumPrecio(Float sumPrecio) {
		this.sumPrecio = sumPrecio;
	}	

}
