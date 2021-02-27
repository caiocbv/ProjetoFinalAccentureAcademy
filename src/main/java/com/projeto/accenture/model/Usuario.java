public class Usuario{
    private int id;
    private String senha;
    private String nome;
    private String cpf;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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