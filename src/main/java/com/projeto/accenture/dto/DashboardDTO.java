package com.projeto.accenture.dto;

import java.time.LocalDate;

import com.projeto.accenture.model.Lancamento;

public class DashboardDTO {
	
	private String login;
	private LocalDate DataInicio;
	private LocalDate DataFim;

	
	public DashboardDTO () {}


	public DashboardDTO(Lancamento obj) {
		super();
		this.login = obj.getConta().getLoginUsuario();
		this.DataInicio = obj.getDataLancamento();
		this.DataFim = obj.getDataLancamento();
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public LocalDate getDataInicio() {
		return DataInicio;
	}


	public void setDataInicio(LocalDate dataInicio) {
		DataInicio = dataInicio;
	}


	public LocalDate getDataFim() {
		return DataFim;
	}


	public void setDataFim(LocalDate dataFim) {
		DataFim = dataFim;
	}
	
}
