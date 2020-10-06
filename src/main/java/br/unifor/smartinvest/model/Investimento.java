package br.unifor.smartinvest.model;

import java.util.ArrayList;

public class Investimento {

	private String nomeEmpresa;
	private ArrayList<Historico> historicos;

	public Investimento(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
		this.historicos = new ArrayList<>();
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public ArrayList<Historico> getHistorico() {
		return historicos;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public void setHistoricos(ArrayList<Historico> historicos)	{
		this.historicos = historicos;
	}

	public double getTotalHistoricos() {
		double total = 0;

		for(Historico h: historicos) {
			total += h.getValorInvestido();
		}

		return total;
	}
}
