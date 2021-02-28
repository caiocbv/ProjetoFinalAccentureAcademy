package com.projeto.accenture.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.projeto.accenture.model.Lancamento;

public class LancamentoDTO {

	@NotEmpty(message="Preenchimento obrigatório")
	private int conta;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String contaDestino;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private LocalDate dataLancamento;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String descricao;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String login;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private int planoConta;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Double valor;
	
	public LancamentoDTO() {}

	public LancamentoDTO(Lancamento obj) {
		this.conta = obj.getConta().getId();
		this.contaDestino = obj.getConta().getLoginUsuario();
		this.dataLancamento = obj.getDataLancamento();
		this.descricao = obj.getDescricao();
		this.login = obj.getConta().getLoginUsuario();
		this.planoConta = obj.getPlanoConta().getId();
		this.valor = obj.getValor();
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
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

	public int getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(int planoConta) {
		this.planoConta = planoConta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
