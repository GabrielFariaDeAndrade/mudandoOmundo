package projeto.model;

public class AlunoTO {

	private long codigoAluno;
	private String nome, endereco, telefone, email, rg;
	private String cpf;
	private String login;
	private int senha;

	public AlunoTO() {

	}

	/* GETTERS */
	public long getCodigoAluno() {
		return codigoAluno;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getRg() {
		return rg;
	}

	public String getCpf() {
		return cpf;
	}

	public String getLogin() {
		return login;
	}

	public int getSenha() {
		return senha;
	}

	/* SETTERS */
	public void setCodigoAluno(long codigoAluno) {
		this.codigoAluno = codigoAluno;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		String texto = "Nome: " + getNome() + "\nEndereço: " + getEndereco() + "\nTelefone: " + getTelefone()
				+ "\nE-mail: " + getEmail() + "\nRG: " + getRg() + "\nCPF: " + getCpf();
		return texto;
	}
}