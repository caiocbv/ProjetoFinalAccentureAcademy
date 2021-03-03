package com.projeto.accenture.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contas")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 20 , name="login")
	private String login;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, length = 20)
	private int numero;
	
	@Column(nullable = false, scale = 2)
	private double saldo = 0;
	
	@Column(nullable = false , name="desc_conta")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "conta", fetch = FetchType.EAGER)
	private List<Lancamento> lancamentos = new ArrayList<>();
	
	public Conta(){}
	
	public Conta(String loginUsuario, double saldo, String descricao){
		this.login=loginUsuario;
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
		return login;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.login = loginUsuario;
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

	@Override
	public String toString() {
		return "Conta [id=" + id + ", loginUsuario=" + login + ", numero=" + numero + ", saldo=" + saldo
				+ ", descricao=" + descricao + "]";
	}

	
	
	
	
		
	

}
