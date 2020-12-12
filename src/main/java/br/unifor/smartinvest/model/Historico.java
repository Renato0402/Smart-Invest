package br.unifor.smartinvest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="historicos")
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="valor_investido")
	private double valorInvestido;

	@Column(name="data_realizada")
	private Date dataRealizada;

	@ManyToOne
	private Investimento investimento;

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


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public Investimento getInvestimento() {
		return investimento;
	}
	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}
}
