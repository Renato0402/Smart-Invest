package br.unifor.smartinvest.model;

public class Corretora extends Entidade {

	private double extrato;

	public Corretora(int corretoraId, String nome) {
		this.id = corretoraId;
		this.nome = nome;
		this.extrato = 0;
	}

	public void setExtrato(double extrato) {
		this.extrato = extrato;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	public double getExtrato() {
		return this.extrato;
	}
	public int getId() {
		return this.id;
	}
}