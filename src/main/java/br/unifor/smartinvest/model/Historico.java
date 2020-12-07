package br.unifor.smartinvest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HISTORICOS")
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double valorInvestido;
	private Date dataRealizada;

	public Historico() {
		this.valorInvestido = 0;
		this.dataRealizada = new Date();
	}

	public double getValorInvestido() {
		return valorInvestido;
	}
	public void setValorInvestido(double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public Date getDataRealizada() {
		return dataRealizada;
	}
	public void setDataRealizada(Date dataRealizada) {
		this.dataRealizada = dataRealizada;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
