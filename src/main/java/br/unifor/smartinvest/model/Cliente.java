package br.unifor.smartinvest.model;

import java.util.ArrayList;

public class Cliente {

	private int clienteId;
	private String nome;
	private double saldo;
	private ArrayList<Corretora> corretoras;

	public Cliente(int clienteId, String nome) {
		this.clienteId = clienteId;
		this.nome = nome;
		this.corretoras = new ArrayList<>();
		this.saldo = 0;
	}

	public int getClienteId() {
		return clienteId;
	}

	public String getNome() {
		return nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public ArrayList<Corretora> getCorretoras() {
		return corretoras;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setCorretoras(ArrayList<Corretora> corretoras) {
		this.corretoras = corretoras;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"clienteId=" + clienteId +
				", nome='" + nome + '\'' +
				", saldo=" + saldo +
				", corretoras=" + corretoras +
				'}';
	}
}
