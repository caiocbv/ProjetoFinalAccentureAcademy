package com.projeto.accenture.model;

import com.projeto.accenture.enums.*;

public class Conta {
	
	private int id;
	private String loginUsuario;
	private String numero;
	private double saldo;
	//private TipoConta descricao;
	
	Conta(){
		this.saldo=0;
	}
	
	Conta(String loginUsuario){
		this.loginUsuario=loginUsuario;
		this.saldo=0;
	}
	
	Conta(String loginUsuario, String numero){
		this.loginUsuario=loginUsuario;
		this.numero= numero;
		this.saldo=0;
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
	
		
	

}
