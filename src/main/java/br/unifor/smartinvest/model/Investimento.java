package br.unifor.smartinvest.model;

import java.util.ArrayList;

public class Investimento {

	private String nomeEmpresa;
	private ArrayList<Historico> historicos;

	public Investimento(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
		this.historicos = new ArrayList<>();
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public void setHistoricos(ArrayList<Historico> historicos)	{
		this.historicos = historicos;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public ArrayList<Historico> getHistorico() {
		return historicos;
	}
}