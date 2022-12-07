package com.nttdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.entities.Cliente;
import com.nttdata.persistence.entities.Contrato;
import com.nttdata.persistence.entities.RankingGastos;
import com.nttdata.services.impl.GestionClientesImpl;
import com.nttdata.services.impl.GestionContratosImpl;
import com.nttdata.services.interfaces.GestionClientesI;
import com.nttdata.services.interfaces.GestionContratosI;
import com.nttdata.utilities.Utilidades;

/**
 * Talleres de Hibernate y Criteria T1H, T2H y T1C
 * 
 * @author Jonatan Carrera Viera
 *
 */
public class MainController {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/** Inicio de sesión */
		final Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		/** Inyección de servicios */
		final GestionClientesI gestionClientes = new GestionClientesImpl(sesion);
		final GestionContratosI gestionContratos = new GestionContratosImpl(sesion);

		/** Auditoría */
		final String createUser = "Jonatan_SYS";
		final Date createDate = new Date();
		
		/** INSERCIÓN DE DATOS */
		
		/** Generación de clientes */
		final Cliente cl1 = new Cliente();
		cl1.setNombre("Jonatan");
		cl1.setPrimerApellido("Carrera");
		cl1.setSegundoApellido("Viera");
		cl1.setDocumentoIdentidad("28929933G");
		cl1.setCreateUser(createUser);
		cl1.setCreateDate(createDate);
		
		final Cliente cl2 = new Cliente();
		cl2.setNombre("Fernando");
		cl2.setPrimerApellido("Perez");
		cl2.setSegundoApellido("Nieto");
		cl2.setDocumentoIdentidad("71367851N");
		cl2.setCreateUser(createUser);
		cl2.setCreateDate(createDate);

		final Cliente cl3 = new Cliente();
		cl3.setNombre("Rafael Felipe");
		cl3.setPrimerApellido("Herrera");
		cl3.setSegundoApellido("Chavez");
		cl3.setDocumentoIdentidad("49528013C");
		cl3.setCreateUser(createUser);
		cl3.setCreateDate(createDate);
		
		final Cliente cl4 = new Cliente();
		cl4.setNombre("Pablo");
		cl4.setPrimerApellido("Dominguez");
		cl4.setSegundoApellido("Romero");
		cl4.setDocumentoIdentidad("28841542W");
		cl4.setCreateUser(createUser);
		cl4.setCreateDate(createDate);
		
		final Cliente cl5 = new Cliente();
		cl5.setNombre("Eva");
		cl5.setPrimerApellido("Cardenas");
		cl5.setSegundoApellido("Bermudez");
		cl5.setDocumentoIdentidad("29628444M");
		cl5.setCreateUser(createUser);
		cl5.setCreateDate(createDate);

		/** Creación de contratos */
		final Contrato ct1 = new Contrato();
		ct1.setFechaVigencia(Utilidades.formatDateForSql("01/11/2022"));
		ct1.setFechaCaducidad(Utilidades.formatDateForSql("01/11/2027"));
		ct1.setPrecio(29.99f);
		ct1.setCliente(cl3);
		ct1.setCreateUser(createUser);
		ct1.setCreateDate(createDate);
		
		final Contrato ct2 = new Contrato();
		ct2.setFechaVigencia(Utilidades.formatDateForSql("01/12/2022"));
		ct2.setFechaCaducidad(Utilidades.formatDateForSql("01/12/2032"));
		ct2.setPrecio(24.99f);
		ct2.setCliente(cl5);
		ct2.setCreateUser(createUser);
		ct2.setCreateDate(createDate);
		
		final Contrato ct3 = new Contrato();
		ct3.setFechaVigencia(Utilidades.formatDateForSql("10/10/2022"));
		ct3.setFechaCaducidad(Utilidades.formatDateForSql("10/10/2027"));
		ct3.setPrecio(29.99f);
		ct3.setCliente(cl4);
		ct3.setCreateUser(createUser);
		ct3.setCreateDate(createDate);
		
		final Contrato ct4 = new Contrato();
		ct4.setFechaVigencia(Utilidades.formatDateForSql("20/09/2022"));
		ct4.setFechaCaducidad(Utilidades.formatDateForSql("20/09/2027"));
		ct4.setPrecio(29.99f);
		ct4.setCliente(cl1);
		ct4.setCreateUser(createUser);
		ct4.setCreateDate(createDate);
		
		final Contrato ct5 = new Contrato();
		ct5.setFechaVigencia(Utilidades.formatDateForSql("25/08/2022"));
		ct5.setFechaCaducidad(Utilidades.formatDateForSql("25/08/2032"));
		ct5.setPrecio(24.99f);
		ct5.setCliente(cl1);
		ct5.setCreateUser(createUser);
		ct5.setCreateDate(createDate);
		
		final Contrato ct6 = new Contrato();
		ct6.setFechaVigencia(Utilidades.formatDateForSql("31/01/2022"));
		ct6.setFechaCaducidad(Utilidades.formatDateForSql("31/01/2032"));
		ct6.setPrecio(24.99f);
		ct6.setCliente(cl4);
		ct6.setCreateUser(createUser);
		ct6.setCreateDate(createDate);
		
		final Contrato ct7 = new Contrato();
		ct7.setFechaVigencia(Utilidades.formatDateForSql("22/02/2022"));
		ct7.setFechaCaducidad(Utilidades.formatDateForSql("22/02/2032"));
		ct7.setPrecio(24.99f);
		ct7.setCliente(cl1);
		ct7.setCreateUser(createUser);
		ct7.setCreateDate(createDate);
		
		final Contrato ct8 = new Contrato();
		ct8.setFechaVigencia(Utilidades.formatDateForSql("14/05/2022"));
		ct8.setFechaCaducidad(Utilidades.formatDateForSql("14/05/2027"));
		ct8.setPrecio(29.99f);
		ct8.setCliente(cl3);
		ct8.setCreateUser(createUser);
		ct8.setCreateDate(createDate);
		
		final Contrato ct9 = new Contrato();
		ct9.setFechaVigencia(Utilidades.formatDateForSql("26/11/2022"));
		ct9.setFechaCaducidad(Utilidades.formatDateForSql("26/11/2027"));
		ct9.setPrecio(29.99f);
		ct9.setCliente(cl4);
		ct9.setCreateUser(createUser);
		ct9.setCreateDate(createDate);
		
		/** Asignación de listas de Contrato */
		List<Contrato> listaProvisional = new ArrayList<>();
		
		listaProvisional.add(ct4);
		listaProvisional.add(ct5);
		listaProvisional.add(ct7);
		cl1.setListaContratos(listaProvisional);
		
		listaProvisional = new ArrayList<>();
		listaProvisional.add(ct1);
		listaProvisional.add(ct8);
		cl3.setListaContratos(listaProvisional);
		
		listaProvisional = new ArrayList<>();
		listaProvisional.add(ct3);
		listaProvisional.add(ct6);
		listaProvisional.add(ct9);
		cl4.setListaContratos(listaProvisional);
		
		listaProvisional = new ArrayList<>();
		listaProvisional.add(ct2);
		cl5.setListaContratos(listaProvisional);
		
		/** Alta de los clientes en la tabla T_CLIENTE una vez ya tienen asignados la lista de contratos */
		gestionClientes.insertarNuevoCliente(cl1);
		gestionClientes.insertarNuevoCliente(cl2);
		gestionClientes.insertarNuevoCliente(cl3);
		gestionClientes.insertarNuevoCliente(cl4);
		gestionClientes.insertarNuevoCliente(cl5);
		
		/** Inserción de contratos en la tabla T_CONTRATO */
		gestionContratos.insertarNuevoContrato(ct1);
		gestionContratos.insertarNuevoContrato(ct2);
		gestionContratos.insertarNuevoContrato(ct3);
		gestionContratos.insertarNuevoContrato(ct4);
		gestionContratos.insertarNuevoContrato(ct5);
		gestionContratos.insertarNuevoContrato(ct6);
		gestionContratos.insertarNuevoContrato(ct7);
		gestionContratos.insertarNuevoContrato(ct8);
		gestionContratos.insertarNuevoContrato(ct9);
		
		/** CONSULTAS */
		
		/** Obtener todos los Cliente de la tabla T_Cliente */
		List<Cliente> lista = gestionClientes.obtenerTodosClientes();
		
		for (Cliente cliente: lista) {
			System.out.println(Utilidades.stringBuilder(cliente.getId().toString(), "|", cliente.getNombre(), "|", cliente.getPrimerApellido(), "|", cliente.getSegundoApellido(),
					"|", cliente.getDocumentoIdentidad()));
		}
		
		/** Obtener los clientes cuyo primer apellido contenga rr */
		List<Cliente> listaPorNombreYApellidos = gestionClientes.buscarPorNombreYApellidos("", "rr", "");
		
		for (Cliente cliente: listaPorNombreYApellidos) {
			System.out.println(Utilidades.stringBuilder(cliente.getId().toString(), "|", cliente.getNombre(), "|", cliente.getPrimerApellido(), "|", cliente.getSegundoApellido(),
					"|", cliente.getDocumentoIdentidad()));
		}
		
		/** Obtener todos los contratos asignados al cliente 1 */
		Long pruebaClienteId = 1l;
		List<Contrato> listaContratosDeUnCliente = gestionContratos.obtenerContratosDeUnCliente(pruebaClienteId);
		
		for (Contrato contrato: listaContratosDeUnCliente) {
			System.out.println(Utilidades.stringBuilder(contrato.getContratoId().toString(), "|", contrato.getFechaVigencia().toString(), "|", contrato.getFechaCaducidad().toString()
					, "|", contrato.getPrecio().toString()));
		}
		
		/** Obtener los clientes que más gastan */
		List<RankingGastos> clientesDeudores = gestionClientes.obtenerLosClientesQueMasGastan();
		
		for (RankingGastos ranking: clientesDeudores) {
			System.out.println(Utilidades.stringBuilder(ranking.getClienteId().toString(), "|", ranking.getDocumentoIdentidad(), "|", ranking.getSumPrecio().toString()));
		}
	}
}
