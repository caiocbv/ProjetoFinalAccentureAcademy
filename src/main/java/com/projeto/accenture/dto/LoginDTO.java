package com.projeto.accenture.dto;

import javax.validation.constraints.NotEmpty;

import com.projeto.accenture.model.Usuario;

public class LoginDTO {
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String login;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	public LoginDTO() {
	}
	
	public LoginDTO(Usuario obj) {
		this.login = obj.getLogin();
		this.senha = obj.getSenha();
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
