package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Cliente;
import br.unifor.smartinvest.model.Corretora;

import java.util.ArrayList;

public class ClienteController {
	public static void alterarNome(Cliente cliente, String nome) {
		cliente.setNome(nome);
	}

	public static void adicionarCorretora(Cliente cliente, Corretora corretora) {
		ArrayList<Corretora> corretoras = cliente.getCorretoras();
		corretoras.add(corretora);
		cliente.setCorretoras(corretoras);
	}
}
