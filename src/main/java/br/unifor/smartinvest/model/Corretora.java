package br.unifor.smartinvest.model;

import javax.persistence.*;

@Entity
@Table(name="corretoras")
public class Corretora {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private double extrato;

	public Corretora() {
		this.extrato = 0;
	}
	public Corretora(int id) {
		this.id = id;
		this.extrato = 0;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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