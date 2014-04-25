package br.bus.recrutamento.business;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.bus.recrutamento.dao.FabricaDAO;
import br.bus.recrutamento.dto.ClienteDTO;
import br.bus.recrutamento.entity.Cliente;
import br.bus.recrutamento.exception.ClienteException;
import br.bus.recrutamento.util.ConverterUtil;

@Stateless
@Remote
public class ClienteBusiness {	

	public void salvarCliente(ClienteDTO clienteDTO){
		clienteDTO.setDtNascimento(new Date());
		
		Cliente cliente = ConverterUtil.convertToCliente(clienteDTO);
		
		
		try {
			FabricaDAO.getClienteDAO().save(cliente);
		} catch (Exception e) {
			throw new ClienteException(e);
		}
	}
	
	public List<ClienteDTO> findAll(){
		
		List<Cliente> lsClientes = FabricaDAO.getClienteDAO().findAll("nome");
		
		return ConverterUtil.convertToDTOList(lsClientes);
		
	}
	
	public ClienteDTO findByID(Long id){		
		Cliente cliente = FabricaDAO.getClienteDAO().findById(id);
		return ConverterUtil.convertToClienteDTO(cliente);
		
	}
	
	public void removerCliente(Long id){
		Cliente cliente  = FabricaDAO.getClienteDAO().findById(id);
		
		FabricaDAO.getClienteDAO().delete(cliente);
	}
}
