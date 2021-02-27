package com.projeto.accenture.model;

import com.projeto.accenture.enums.*;

public class Conta {
	
	private int id;
	private String loginUsuario;
	private String numero;
	private double saldo = 0;
	private String descricao;
	
	Conta(){
	}
	
	Conta(String loginUsuario, String numero, double saldo, String descricao){
		this.loginUsuario=loginUsuario;
		this.numero= numero;
		this.saldo=saldo;
		this.descricao=descricao;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
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

	@Override
	public String toString() {
		return "Conta [id=" + id + ", loginUsuario=" + loginUsuario + ", numero=" + numero + ", saldo=" + saldo
				+ ", descricao=" + descricao + "]";
	}

	
	
	
	
		
	

}
