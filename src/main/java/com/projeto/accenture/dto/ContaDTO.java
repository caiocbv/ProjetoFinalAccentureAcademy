package com.projeto.accenture.dto;

import javax.validation.constraints.NotEmpty;

import com.projeto.accenture.model.Conta;


public class ContaDTO {
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String loginUsuario;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private int numero;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private double saldo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String descricao;
	
	public ContaDTO() {}
	
	public ContaDTO(Conta obj){
		this.loginUsuario=obj.getLoginUsuario();
		this.saldo=obj.getSaldo();
		this.descricao=obj.getDescricao();
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
