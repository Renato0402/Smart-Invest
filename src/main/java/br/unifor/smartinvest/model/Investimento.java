package br.unifor.smartinvest.model;

import java.util.ArrayList;

public class Investimento {

	private String empresa;
	private ArrayList<Historico> historico;

	public Investimento(String empresa) {
		this.empresa = empresa;
		this.historico = new ArrayList<>();
	}

	public String getEmpresa() {
		return empresa;
	}
	public ArrayList<Historico> getHistorico() {
		return historico;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public void setHistorico(ArrayList<Historico> historico) {
		this.historico = historico;
	}
}
