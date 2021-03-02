package com.projeto.accenture.dto;

import java.util.List;

import com.projeto.accenture.model.Conta;
import com.projeto.accenture.model.Lancamento;

public class ContaDTO {
	Conta conta;
	List<Lancamento> lancamentos;
	
	public Conta getConta() {
		return conta;
	}	

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public ContaDTO(Conta conta, List<Lancamento> lancamentos) {
		super();
		this.conta = conta;
		this.lancamentos = lancamentos;
	}
	
	public ContaDTO() {
		super();
	}
}
