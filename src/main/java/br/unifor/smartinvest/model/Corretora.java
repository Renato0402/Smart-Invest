package br.unifor.smartinvest.model;

import javax.persistence.*;

@Entity
@Table(name="corretoras")
public class Corretora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private double extrato;

	public Corretora() {
		this.extrato = 0;
	}
	// Construtor alternativo necessário para evitar o erro de falta de serializer
	public Corretora(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getExtrato() {
		return extrato;
	}
	public void setExtrato(double extrato) {
		this.extrato = extrato;
	}
}