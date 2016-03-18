package projeto.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class CursoTO {
	protected int codigoCurso;
	protected String nomeCurso;
	protected String horarioPrevisto;
	protected Date dataInicio, dataTermino;
	protected int numeroVagas;
	protected double valorCurso;

	public CursoTO() {
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
}