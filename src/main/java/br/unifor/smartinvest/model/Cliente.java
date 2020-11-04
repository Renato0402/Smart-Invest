package br.unifor.smartinvest.model;

public class Cliente extends Entidade{

	private double saldo;

	// Para compartilhar com outro usuário, utilizar o id
	public Cliente(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.saldo = 0;
	}

	public int getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public double getSaldo() {
		return saldo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}