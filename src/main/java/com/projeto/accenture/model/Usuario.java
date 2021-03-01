package com.projeto.accenture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="Usuarios", uniqueConstraints={@UniqueConstraint(columnNames={"cpf","login"})})
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotEmpty(message="Preenchimento a senha é obrigatório")
	@Column(nullable = false)
    private String senha;
	
	@NotEmpty(message="Preenchimento do nome obrigatório")
	@Column(nullable = false)
    private String nome;
	
	@NotEmpty(message="Preenchimento do CPF obrigatório")
	@Column(nullable = false)
    private String cpf;
	
	@NotEmpty(message="Preenchimento do login obrigatório")
	@Column(nullable = false, length = 20)
    private String login;

    public Usuario(){
        
    }

	public Usuario(String senha, String nome, String cpf, String login) {
		super();
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", senha=" + senha + ", nome=" + nome + ", cpf=" + cpf + ", login=" + login + "]";
	}
    
    
    
}