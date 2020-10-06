package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Historico;
import br.unifor.smartinvest.model.Investimento;

import java.util.ArrayList;

public class InvestimentoController {
	public static void alterarNome(Investimento investimento, String nomeInvestimento) {
		investimento.setNomeEmpresa(nomeInvestimento);
	}

	public static void adicionarHistorico(Investimento investimento, Historico historico) {
		ArrayList<Historico> historicos = investimento.getHistoricos();
		historicos.add(historico);
		investimento.setHistoricos(historicos);
	}
}