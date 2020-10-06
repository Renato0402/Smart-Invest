package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Investimento;

public class InvestimentoController {
	public static void alterarNome(Investimento investimento, String nomeInvestimento) {
		investimento.setNomeEmpresa(nomeInvestimento);
	}
}