package br.unifor.smartinvest.model;

import java.util.ArrayList;

public class Investimento extends Entidade{

	private int cliente_id;
	private int corretora_id;
	private ArrayList<Historico> historicos;

	public Investimento(int id, String nome_empresa, int cliente_id, int corretora_id) {
		this.id = id;
		this.nome = nome_empresa;
		this.cliente_id = cliente_id;
		this.corretora_id = corretora_id;
		this.historicos = new ArrayList<>();
	}

	public void addHistorico(Historico historico) {
		if(historico == null)
			return;

		this.historicos.add(historico);
	}

	public ArrayList<Historico> getHistoricos() {
		return historicos;
	}

	public int getClienteId() {
		return cliente_id;
	}
	public int getCorretoraId() {
		return corretora_id;
	}
}