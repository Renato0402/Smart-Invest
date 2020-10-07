package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Cliente;
import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.model.Investimento;

import java.util.ArrayList;

public class InvestimentoController {
	private ArrayList<Investimento> listaInvestimentos;

	public InvestimentoController() {
		this.listaInvestimentos = new ArrayList<>();
	}

	public Cliente verCliente(int clienteId) {
		// Retornar cliente pelo banco de dados
		return null;
	}

	public Corretora verCorretora(int corretoraId) {
		// Retornar corretora pelo banco de dados
		return null;
	}

	// Métodos para adicionar à lista de investimentos //
}
