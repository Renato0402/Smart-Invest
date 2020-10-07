package br.unifor.smartinvest.model;

import java.util.ArrayList;

public class Investimento {

	private Cliente cliente;
	private Corretora corretora;
	private ArrayList<Historico> historicos;

	public Investimento(Cliente cliente, Corretora corretora) {
		this.cliente = cliente;
		this.corretora = corretora;
		this.historicos = new ArrayList<>();
	}

	public void setHistoricos(ArrayList<Historico> historicos)	{
		this.historicos = historicos;
	}

	public ArrayList<Historico> getHistoricos() {
		return historicos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Corretora getCorretora() {
		return corretora;
	}
}