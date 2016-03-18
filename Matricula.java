package projeto.model;

import java.util.Date;

public class Matricula {

	private int codigoMatricula; 
	private Date dataMatricula;
	private double valorMatricula;
	private boolean statusPagamento, statusMatricula;

	public Matricula() {

	}
	
	/* GETTERS */
	public int getCodigoMatricula() {
		return codigoMatricula;
	}
	public Date getDataMatricula() {
		return dataMatricula;
	}
	public double getValorMatricula() {
		return valorMatricula;
	}
	public boolean isStatusPagamento() {
		return statusPagamento;
	}
	public boolean isStatusMatricula() {
		return statusMatricula;
	}
	
	/* SETTERS */
	public void setCodigoMatricula(int codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public void setValorMatricula(double valorMatricula) {
		this.valorMatricula = valorMatricula;
	}
	public void setStatusPagamento(boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	public void setStatusMatricula(boolean statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	public void fazerMatricula() {
		
	}
	
	public void cancelarMatricula() {
		
	}
	
	public void consultarMatricula() {
		
	}
	
	public void gerarRelatorioMatriculas() {
		
	}
	
	public void gerarRelatorioCancelamentos() {
		
	}
	
}// fim da classe