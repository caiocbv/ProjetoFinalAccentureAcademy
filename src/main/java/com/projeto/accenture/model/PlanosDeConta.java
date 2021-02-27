package com.projeto.accenture.model;

public class PlanosDeConta {
	
	private int id;
	private String descricao;
	private String login;
	//private TipoMovimento tipoMovimento
	
	public PlanosDeConta(){
		
	}
	
	public PlanosDeConta(int id,String descricao,String login){
		this.id=id;
		this.descricao=descricao;
		this.login=login;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return "PlanosDeConta [id=" + id + ", descricao=" + descricao + ", login=" + login + "]";
	}
	
	
}
