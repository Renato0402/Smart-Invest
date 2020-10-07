package br.unifor.smartinvest.model;

import java.util.ArrayList;

public class Cliente {

	private int clienteId;
	private String nome;
	private double saldo;

	public Cliente(int clienteId, String nome) {
		this.clienteId = clienteId;
		this.nome = nome;
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

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
