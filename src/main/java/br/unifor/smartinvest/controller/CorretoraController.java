package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Cliente;
import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.model.Investimento;

import java.util.ArrayList;

public class CorretoraController {
    public static void alterarNome(Corretora corretora, String nomeCorretora) {
        corretora.setNome(nomeCorretora);
    }

    public static void adicionarInvestimento(Corretora corretora, Investimento investimento) {
        ArrayList<Investimento> investimentos = corretora.getInvestimentos();
        investimentos.add(investimento);
        corretora.setInvestimentos(investimentos);
    }
}
