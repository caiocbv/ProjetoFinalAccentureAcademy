package com.projeto.accenture.dto;

import com.projeto.accenture.model.PlanosDeConta;

public class PlanoContaDTO {
	
	private Integer id;
	private String descricao;
	private int tipoMovimento;
	
	public PlanoContaDTO () {}
	
	public PlanoContaDTO(PlanosDeConta obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.tipoMovimento = obj.getTipoMovimento().getCod();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(int tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	
	

}
