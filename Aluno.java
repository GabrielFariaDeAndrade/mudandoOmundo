package projeto.model;

import javax.swing.JOptionPane;

public class Aluno {

	private long codigoAluno;
	private String nome, endereco, telefone, email, rg;
	private String cpf;
	private String login;
	private int senha;

	public Aluno() {

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

	/* C.R.U.D */
	public void incluir(long codigoAluno, String nome, String endereco, String telefone, String email, String rg,
			String cpf) {
		AlunoTO aluno = new AlunoTO();

		aluno.setCodigoAluno(codigoAluno);
		aluno.setNome(nome);
		aluno.setEndereco(endereco);
		aluno.setTelefone(telefone);
		aluno.setEmail(email);
		aluno.setRg(rg);
		aluno.setCpf(cpf);

		AlunoDAO bd = new AlunoDAO();

		if (bd.incluir(aluno)) {
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso.");
		}
	}

	public void alterar(long cod, String nome, String endereco, String telefone, String email, String rg, String cpf) {
		AlunoTO aluno = new AlunoTO();
		aluno.setCodigoAluno(cod);
		aluno.setNome(nome);
		aluno.setEndereco(endereco);
		aluno.setEmail(email);
		aluno.setTelefone(telefone);
		aluno.setRg(rg);
		aluno.setCpf(cpf);
		
		AlunoDAO bd = new AlunoDAO();
		
		if(bd.alterar(aluno)) {
			JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
		}
	}

	public void excluir(long raAluno) {
		AlunoDAO bd = new AlunoDAO();
		
		if(bd.excluir(raAluno)) {
			JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso!");
		}
	}

	public AlunoTO consultar(long raAluno) {
		AlunoDAO bd = new AlunoDAO();
		return bd.consultar(raAluno);
	}

	@Override
	public String toString() {
		String texto = "Nome: "+ getNome() +
				"\nEndereço: " + getEndereco() +
				"\nTelefone: " + getTelefone() + 
				"\nE-mail: " + getEmail() + 
				"\nRG: " + getRg() + 
				"\nCPF: "+ getCpf();
		return texto;
	}

	public boolean fazerLogin(String login, int senha) {
		boolean ok = false;
		if(getLogin().equals(login) && getSenha() == senha)
			ok = true;
		
		return ok;
	}

}// fim da classe