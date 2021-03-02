package com.projeto.accenture.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.projeto.accenture.model.enums.TipoMovimento;

@Entity
@Table(name="lancamentos")
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="conta_id")
	private Conta conta;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PlanosDeConta planoConta;
	
	@Column(nullable = false, scale = 2)
	private Double valor;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private int tipoMovimento;
	
	@Column(nullable = false, columnDefinition = "DATE")
	@DateTimeFormat(iso = ISO.DATE, pattern = "")
	private LocalDate dataLancamento;
	
	public Lancamento() {}

	public Lancamento(Conta conta, PlanosDeConta planoConta, Double valor,String descricao, int tipoMovimento,
			LocalDate dataLancamento) {
		this.conta = conta;
		this.planoConta = planoConta;
		this.valor = valor;
		this.descricao = descricao;
		this.tipoMovimento = tipoMovimento;
		this.dataLancamento = dataLancamento;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public PlanosDeConta getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(PlanosDeConta planoConta) {
		this.planoConta = planoConta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoMovimento getTipoMovimento() {
		return TipoMovimento.toEnum(tipoMovimento);
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento.getCod();
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

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", conta=" + conta + ", planoConta=" + planoConta + ", valor=" + valor
				+ ", descricao=" + descricao + ", tipoMovimento=" + tipoMovimento + ", dataLancamento=" + dataLancamento
				+ "]";
	}

	
	
	
	
	
}
