package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Historico;
import br.unifor.smartinvest.model.Investimento;
import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@GetMapping("/clientes/{id}")
	public ResponseEntity<ArrayList<Investimento>> getInvestimentosPorCliente(@PathVariable int id) {
		ArrayList<Investimento> investimentos = this.listaInvestimentos;

		//! Refatorar para não repetir a mesma estrutura
			// Filtrar pelo id do cliente
		investimentos = filtrarInvestimentosPorCliente(investimentos, id);


		// response entity ou anotação
		// @ResponseEntity<Tipo>
		// Retornar ResponseEntity.<método com ou sem body>.build()(se necessário)
		return ResponseEntity.ok(investimentos);
	}

	@GetMapping("clientes/{clienteId}/corretoras/{corretoraId}")
	public ResponseEntity<ArrayList<Investimento>> getInvestimentosCorretoraCliente(@PathVariable int clienteId, @PathVariable int corretoraId) {
		ArrayList<Investimento> investimentos = this.listaInvestimentos;

		//! Refatorar para não repetir a mesma estrutura
		// Filtrar pelo id do cliente
		investimentos = filtrarInvestimentosPorCorretora(investimentos, corretoraId);
		investimentos = filtrarInvestimentosPorCliente(investimentos, clienteId);


		// response entity ou anotação
		// @ResponseEntity<Tipo>
		// Retornar ResponseEntity.<método com ou sem body>.build()(se necessário)
		return ResponseEntity.ok(investimentos);
	}

	// Adicionar um investimento
	@PostMapping
	public ResponseEntity<String> post(@RequestBody Investimento investimento) {
		if (adicionarInvestimento(investimento))
			return ResponseEntity.ok("Investimento cadastrado com sucesso!");

		return ResponseEntity.badRequest().body("Erro ao cadastrar investimento!");
	}

	// Realizar uma transação
	@PostMapping("/{id}/historicos")
	public ResponseEntity<String> post(@PathVariable("id") int id, @RequestBody Historico historico) {
		Investimento investimento = buscarInvestimentoPorId(id);

		if (investimento != null) {
			investimento.addHistorico(historico);
			return ResponseEntity.ok("Novo histórico alterado!");
		}

		return ResponseEntity.badRequest().body("Erro ao cadastrar investimento!");
	}

	// Remover um investimento ao buscar pelo seu id
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if(removerInvestimento(id))
			return ResponseEntity.ok("Remoção de investimento realizada com sucesso!");

		return ResponseEntity.badRequest().body("Erro ao remover investimento!");
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

}
