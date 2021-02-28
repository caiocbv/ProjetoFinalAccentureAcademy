package com.projeto.accenture.model.dto;

import javax.validation.constraints.NotEmpty;

import com.projeto.accenture.model.Usuario;

public class UsuarioDTO {
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String login;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cpf;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(Usuario obj) {
		this.login = obj.getLogin();
		this.nome = obj.getNome();
		this.senha = obj.getSenha();
		this.cpf = obj.getCpf();
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
