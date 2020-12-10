package br.unifor.smartinvest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="historicos")
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name="valor_investido")
	private double valorInvestido;

	@Column(name="data_realizada")
	private Date dataRealizada;

	@ManyToOne(targetEntity = Investimento.class)
	private int investimento_id;

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

	public int getInvestimento_id() {
		return investimento_id;
	}

	public void setInvestimento_id(int investimento_id) {
		this.investimento_id = investimento_id;
	}
}
