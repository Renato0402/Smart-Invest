package br.unifor.smartinvest.model;

public class Corretora extends Entidade {

	private double extrato;

	public Corretora(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.extrato = 0;
	}

	public void setExtrato(double extrato) {
		this.extrato = extrato;
	}
	public double getExtrato() {
		return this.extrato;
	}
}