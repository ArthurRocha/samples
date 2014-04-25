package br.bus.recrutamento.dto;

import java.io.Serializable;
import java.util.Date;

import br.bus.recrutamento.entity.Cliente;

public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1552586903319911408L;
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String endereco;
	private String cep;
	private Date dtNascimento;
	private String telefone;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Long id, String nome, String sobrenome, String endereco,
			String cep, Date dtNascimento, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.cep = cep;
		this.dtNascimento = dtNascimento;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
