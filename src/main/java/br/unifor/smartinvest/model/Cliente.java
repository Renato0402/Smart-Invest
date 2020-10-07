package br.unifor.smartinvest.model;

public class Cliente extends Entidade{

	private double saldo;

	public Cliente(int clienteId, String nome) {
		this.id = clienteId;
		this.nome = nome;
		this.saldo = 0;
	}

	public int getClienteId() {
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
