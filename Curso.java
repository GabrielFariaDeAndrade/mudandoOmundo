package projeto.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class Curso {

	protected int codigoCurso;
	protected String nomeCurso;
	protected String horarioPrevisto;
	protected Date dataInicio, dataTermino;
	protected int numeroVagas;
	protected double valorCurso;

	public Curso() {
	}

	/* GETTERS */
	public int getCodigoCurso() {
		return codigoCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public String getHorarioPrevisto() {
		return horarioPrevisto;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public double getValorCurso() {
		return valorCurso;
	}

	/* SETTERS */
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public void setHorarioPrevisto(String horarioPrevisto) {
		this.horarioPrevisto = horarioPrevisto;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public void setValorCurso(double valorCurso) {
		this.valorCurso = valorCurso;
	}

	/* C.R.U.D */
	public void incluir(int codCurso, String nomeCurso, Date dataInicio, Date dataTermino, String horario,
			int numeroVagas, double valor) {
		CursoTO curso = new CursoTO();

		curso.setCodigoCurso(codCurso);
		curso.setNomeCurso(nomeCurso);
		curso.setDataInicio(dataInicio);
		curso.setDataTermino(dataTermino);
		curso.setHorarioPrevisto(horario);
		curso.setNumeroVagas(numeroVagas);
		curso.setValorCurso(valor);

		CursoDAO bd = new CursoDAO();

		if (bd.incluir(curso)) {
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
		}
	}

	public void alterar(int cod, String nome, double valor, Date dataIni, Date dataTerm, String horario, int numVagas) {
		CursoTO curso = new CursoTO();

		curso.setCodigoCurso(cod);
		curso.setNomeCurso(nome);
		curso.setDataInicio(dataIni);
		curso.setDataTermino(dataTerm);
		curso.setHorarioPrevisto(horario);
		curso.setNumeroVagas(numVagas);
		curso.setValorCurso(valor);

		CursoDAO bd = new CursoDAO();
		if (bd.alterar(curso)) {
			JOptionPane.showMessageDialog(null, "Curso alterado com sucesso!");
		}
	}

	public void excluir(int cod) {
		CursoDAO bd = new CursoDAO();

		if (bd.excluir(cod)) {
			JOptionPane.showMessageDialog(null, "Curso deletado com sucesso.");
		}
	}

	public CursoTO consultar(int codigo) {
		CursoDAO bd = new CursoDAO();
		return bd.consultar(codigo);
	}

	public void consultarCursosDisponiveis() {

	}

	@Override
	public String toString() {
		String texto = "Nome do curso: " + getNomeCurso() + "\nData de início: "
				+ formatarData(getDataInicio().getTime()) + "\nData de término: "
				+ formatarData(getDataTermino().getTime()) + "\nHorário: " + getHorarioPrevisto() + "\nValor do curso: "
				+ NumberFormat.getCurrencyInstance().format(getValorCurso()) + "\nNº de Vagas: " + getNumeroVagas();
		return texto;
	}

	private String formatarData(long tempo) {
		java.util.Date data = new Date(tempo);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(data);
	}

}// fim da classe