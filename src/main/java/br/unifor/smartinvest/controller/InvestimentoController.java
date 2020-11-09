package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Historico;
import br.unifor.smartinvest.model.Investimento;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {
	private ArrayList<Investimento> listaInvestimentos;

	public InvestimentoController() {
		this.listaInvestimentos = new ArrayList<>();
	}

	// Mostrar todos os investimentos
	//! Ao invés de aplicar no request query, utilizar argumento na própria url
	//! Alterar strings para request query
	@GetMapping
	public ArrayList<Investimento> get(
			@RequestParam(value = "cliente_id", required = false, defaultValue = "-1") int cliente_id,
			@RequestParam(value = "corretora_id",required = false, defaultValue = "-1") int corretora_id,
			@RequestParam(value = "investimento_id", required = false, defaultValue = "-1") int investimento_id
	) {
		ArrayList<Investimento> investimentos = this.listaInvestimentos;

		//! Refatorar para não repetir a mesma estrutura
		if(cliente_id != -1)
			// Filtrar pelo id do cliente
			investimentos = filtrarInvestimentosPorCliente(investimentos, cliente_id);

		if(corretora_id != -1)
			// Filtrar pelo id de corretora
			investimentos = filtrarInvestimentosPorCorretora(investimentos, corretora_id);

		if(investimento_id != -1)
			// Filtrar o investimento exato depois das outras filtragens
			investimentos = filtrarInvestimentosPorId(investimentos, investimento_id);

		// response entity ou anotação
		// @ResponseEntity<Tipo>
		// Retornar ResponseEntity.<método com ou sem body>.build()(se necessário)
		return investimentos;
	}

	// Adicionar um investimento
	@PostMapping
	public String post(@RequestBody Investimento investimento) {
		if (adicionarInvestimento(investimento))
			return "Investimento cadastrado com sucesso!";

		return "Erro ao cadastrar investimento!";
	}

	// Realizar uma transação
	@PostMapping("/{id}/historicos")
	public String post(@PathVariable("id") int id, @RequestBody Historico historico) {
		Investimento investimento = buscarInvestimentoPorId(id);

		if (investimento != null) {
			investimento.addHistorico(historico);
			return "Novo histórico alterado!";
		}

		return "Erro ao cadastrar investimento!";
	}

	// Remover um investimento ao buscar pelo seu id
	@DeleteMapping
	public String delete(@RequestHeader int id) {
		if(removerInvestimento(id))
			return "Remoção de investimento realizada com sucesso!";

		return "Erro ao remover investimento!";
	}

	//// Funções
	private boolean adicionarInvestimento(Investimento investimento) {
		if(investimento == null) return false;

		for(Investimento i: listaInvestimentos)
			if(investimento.getId() == i.getId())
				return false;

		listaInvestimentos.add(investimento);
		return true;
	}

	private Investimento buscarInvestimentoPorId(int id) {
		for(Investimento i: listaInvestimentos)
			if(i.getId() == id)
				return i;

		return null;
	}

	private boolean removerInvestimento(int id) {
		Investimento investimento = buscarInvestimentoPorId(id);

		if(investimento == null)
			return false;

		listaInvestimentos.remove(investimento);
		return true;
	}

	//! Refatorar para não repetir a mesma estrutura
	private ArrayList<Investimento> filtrarInvestimentosPorCliente(ArrayList<Investimento> investimentos, int cliente_id) {
		ArrayList<Investimento> investimentosFiltrados = new ArrayList<>();
		for(Investimento i: investimentos)
			if(i.getClienteId() == cliente_id)
				investimentosFiltrados.add(i);

		return investimentosFiltrados;
	}

	private ArrayList<Investimento> filtrarInvestimentosPorCorretora(ArrayList<Investimento> investimentos, int corretora_id) {
		ArrayList<Investimento> investimentosFiltrados = new ArrayList<>();
		for(Investimento i: investimentos)
			if(i.getCorretoraId() == corretora_id)
				investimentosFiltrados.add(i);

		return investimentosFiltrados;
	}

	private ArrayList<Investimento> filtrarInvestimentosPorId(ArrayList<Investimento> investimentos, int investimento_id) {
		ArrayList<Investimento> investimentosFiltrados = new ArrayList<>();
		for(Investimento i: investimentos)
			if(i.getId() == investimento_id)
				investimentosFiltrados.add(i);

		return investimentosFiltrados;
	}
}
