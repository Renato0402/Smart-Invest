package br.unifor.smartinvest.model;

public class Cliente extends Entidade{

	private double saldo;

	// Para compartilhar com outro usuário, utilizar o id
	public Cliente(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.saldo = 0;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}