package br.bus.recrutamento.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.bus.recrutamento.business.ClienteBusiness;
import br.bus.recrutamento.dto.ClienteDTO;

@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2777594233311030032L;
	
	@EJB
	private ClienteBusiness clienteBusiness;
	@Inject
	private ClienteCadastroMB cadastroMB;
	
	private ClienteDTO cliente;
	private List<ClienteDTO> lsClientes;
	private Long clienteEmEdicao;
	private int page = 1;
	
	
	@PostConstruct
	public void init(){
		lsClientes = clienteBusiness.findAll();
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

	public List<ClienteDTO> getLsClientes() {
		return lsClientes;
	}

	public void setLsClientes(List<ClienteDTO> lsClientes) {
		this.lsClientes = lsClientes;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Long getClienteEmEdicao() {
		return clienteEmEdicao;
	}

	public void setClienteEmEdicao(Long clienteEmEdicao) {
		cadastroMB.setCliente(clienteBusiness.findByID(clienteEmEdicao));
		this.clienteEmEdicao = clienteEmEdicao;
	}
	
	public String editar(Long id) {
		setClienteEmEdicao(id);
		return novo();
	}
	
	public void remove() {

		clienteBusiness.removerCliente(clienteEmEdicao);

		lsClientes = clienteBusiness.findAll();
	}
	
	public String novo(){
		return "cadastro.xhtml";
		
	}
}
