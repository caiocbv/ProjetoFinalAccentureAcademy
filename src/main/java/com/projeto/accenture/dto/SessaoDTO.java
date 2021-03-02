package com.projeto.accenture.dto;

	
import java.util.Date;

import com.projeto.accenture.model.Usuario;



	public class SessaoDTO {
		private Usuario usuario;
		private String login;
		private String token;
		private Date dataInicio;
		private Date dataFim;
		
		public SessaoDTO() {}
		
		public SessaoDTO(Usuario usuario, String login, String token, Date dataInicio, Date dataFim) {
			this.usuario = usuario;
			this.login = login;
			this.token = token;
			this.dataInicio = dataInicio;
			this.dataFim = dataFim;
		}
		
		public Usuario getUsuario() {
			return usuario;
		}
		
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public Date getDataInicio() {
			return dataInicio;
		}
		public void setDataInicio(Date dataInicio) {
			this.dataInicio = dataInicio;
		}
		public Date getDataFim() {
			return dataFim;
		}
		public void setDataFim(Date dataFim) {
			this.dataFim = dataFim;
		}
		
	}

