package com.projeto.accenture.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.accenture.model.Lancamento;
import com.projeto.accenture.model.enums.TipoMovimento;

public class LancamentoDTO {
	
	@JsonIgnore
	private Integer id;
	
	private Integer conta;
	
	private String contaDestino;
	
	private LocalDate dataLancamento;
	
	private String descricao;
	
	private String login;
	
	private int planoConta;
	
	private int tipoMovimento;
	
	private Double valor;
	
	public LancamentoDTO() {}

	public LancamentoDTO(Lancamento obj) {
		this.id = obj.getId();
		this.conta = obj.getConta().getId();
		this.contaDestino = obj.getContaDestino();
		this.dataLancamento = obj.getDataLancamento();
		this.descricao = obj.getDescricao();
		this.login = obj.getConta().getLoginUsuario();
		this.planoConta = obj.getPlanoConta();
		this.tipoMovimento = obj.getTipoMovimento();
		this.valor = obj.getValor();
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
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

	public TipoMovimento getTipoMovimento() {
		return TipoMovimento.toEnum(getId());
	}

	public void setTipoMovimento(int tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	@Override
	public String toString() {
		return "LancamentoDTO [id=" + id + ", conta=" + conta + ", contaDestino=" + contaDestino + ", dataLancamento="
				+ dataLancamento + ", descricao=" + descricao + ", login=" + login + ", planoConta=" + planoConta
				+ ", tipoMovimento=" + tipoMovimento + ", valor=" + valor + "]";
	}
	
	
	
	

	
}
