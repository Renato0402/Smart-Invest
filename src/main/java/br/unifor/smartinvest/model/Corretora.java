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
}
