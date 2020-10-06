package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.model.Investimento;

import java.util.ArrayList;

public class InvestimentoController {
	public static void alterarNome(Investimento investimento, String nomeInvestimento) {
		investimento.setNomeEmpresa(nomeInvestimento);
	}

	public static void adicionarInvestimento(Corretora corretora, Investimento investimento) {
		ArrayList<Investimento> investimentos = corretora.getInvestimentos();
		investimentos.add(investimento);
		corretora.setInvestimentos(investimentos);
	}
}
