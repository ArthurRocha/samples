package br.bus.recrutamento.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.bus.recrutamento.dto.ClienteDTO;

@Entity
@Table
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5776172392701839400L;

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String sobrenome;
	private String endereco;
	private String cep;
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	private String telefone;

	public Cliente() {
		super();
	}

	public Cliente(Long id, String nome, String sobrenome, String endereco, String cep,
			Date dtNascimento, String telefone) {
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
