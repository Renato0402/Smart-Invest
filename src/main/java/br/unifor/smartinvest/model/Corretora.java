package br.unifor.smartinvest.model;

import java.util.ArrayList;

public class Corretora {

	private String nome;
	private double extrato;
	private ArrayList<Investimento> investimentos;

	public Corretora(String nome) {
		this.investimentos = new ArrayList<>();
		this.extrato = 0;
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setExtrato(double extrato) {
		this.extrato = extrato;
	}

	public void setInvestimentos(ArrayList<Investimento> investimentos) {
		this.investimentos = investimentos;
	}

	public String getNome() {
		return this.nome;
	}

	public double getExtrato() {
		return this.extrato;
	}

	public ArrayList<Investimento> getInvestimentos() {
		return this.investimentos;
	}	
}
