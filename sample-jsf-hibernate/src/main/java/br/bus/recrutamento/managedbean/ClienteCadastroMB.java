package br.bus.recrutamento.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.bus.recrutamento.business.ClienteBusiness;
import br.bus.recrutamento.dto.ClienteDTO;

@ManagedBean
@ViewScoped
public class ClienteCadastroMB implements Serializable{
	
	private static final long serialVersionUID = -7376708201804597443L;

	@EJB
	private ClienteBusiness clienteBusiness;
	
	private ClienteDTO cliente;
	
	@PostConstruct
	public void init(){
		cliente = new ClienteDTO();
	}
	
	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	public void acaoSalvar(){
		salvarCliente();
	}
	
	private void salvarCliente(){
		clienteBusiness.salvarCliente(cliente);
	}

}
