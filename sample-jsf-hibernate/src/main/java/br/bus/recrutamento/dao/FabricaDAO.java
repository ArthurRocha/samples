package br.bus.recrutamento.dao;

import br.bus.recrutamento.dao.impl.ClienteDAOImpl;

public class FabricaDAO {

	private static IClienteDAO clienteDAO;
	
	
	public static IClienteDAO getClienteDAO(){
		if(clienteDAO == null){
			clienteDAO = new ClienteDAOImpl();
		}
		return clienteDAO;
	}
}
