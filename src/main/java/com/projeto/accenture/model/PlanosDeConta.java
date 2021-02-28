package com.projeto.accenture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.projeto.accenture.model.enums.TipoMovimento;

@Entity
@Table(name="planosContas")
public class PlanosDeConta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_planoConta")
	private int id;
	
	@Column(nullable = false, name="desc_planoConta")
	private String descricao;
	
	@Column(nullable = false)
	private String login;
	

	@Column(nullable = false)
	private int tipoMovimento;
	
	public PlanosDeConta() {}
	
	public PlanosDeConta(String descricao, Usuario login, int tipoMovimento) {
		this.descricao = descricao;
		this.login = login.getLogin();
		this.tipoMovimento = tipoMovimento;
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
	
	public TipoMovimento getTipoMovimento() {
		return TipoMovimento.toEnum(tipoMovimento);
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento.getCod();
	}
	@Override
	public String toString() {
		return "PlanosDeConta [id=" + id + ", descricao=" + descricao + ", login=" + login + "]";
	}
	
	
}
