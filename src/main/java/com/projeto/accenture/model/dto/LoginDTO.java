package com.projeto.accenture.model.dto;

import javax.validation.constraints.NotEmpty;

public class LoginDTO {
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String login;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	public LoginDTO() {
		// TODO Auto-generated constructor stub
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
