package br.bus.recrutamento.util;

import java.util.ArrayList;
import java.util.List;

import br.bus.recrutamento.dto.ClienteDTO;
import br.bus.recrutamento.entity.Cliente;

public class ConverterUtil {
	
	public static Cliente convertToCliente(ClienteDTO clienteDTO) {
		if (clienteDTO == null) {
			return new Cliente();
		}
		return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getSobrenome(),
				clienteDTO.getEndereco(), clienteDTO.getCep(),
				clienteDTO.getDtNascimento(), clienteDTO.getTelefone());
	}
	
	public static ClienteDTO convertToClienteDTO(Cliente cliente) {
		if (cliente == null) {
			return new ClienteDTO();
		}
		return new ClienteDTO(cliente .getId(), cliente.getNome(), cliente.getSobrenome(),
				cliente.getEndereco(), cliente.getCep(),
				cliente.getDtNascimento(), cliente.getTelefone());
	}
	
	
	public static List<ClienteDTO> convertToDTOList(List<Cliente> lsClientes){
		if(lsClientes == null){
			return new ArrayList<ClienteDTO>();
		}
		
		List<ClienteDTO> lsClientesDTO = new ArrayList<ClienteDTO>();
		
		for(Cliente cliente : lsClientes){
			lsClientesDTO.add(convertToClienteDTO(cliente));
		}
		
		return lsClientesDTO;
		
	}
}
