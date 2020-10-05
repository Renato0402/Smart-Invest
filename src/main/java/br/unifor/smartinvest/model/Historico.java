package br.unifor.smartinvest.model;

import java.util.Date;

public class Historico {

	private double valorInvestido;
	private Date dataRealizada;

	public Historico() {
		this.valorInvestido = 0;
		this.dataRealizada = new Date();
	}

	public Historico(double valorInvestido, Date dataRealizada) {
		this.valorInvestido = valorInvestido;
		this.dataRealizada = dataRealizada;
	}

	public double getValorInvestido() {return valorInvestido;}
	public Date getDataRealizada() {return dataRealizada;}

	public void setValorInvestido(double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}
	public void setDataRealizada(Date dataRealizada) {
		this.dataRealizada = dataRealizada;
	}
}
