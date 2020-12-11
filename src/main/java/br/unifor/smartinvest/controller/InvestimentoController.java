package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Historico;
import br.unifor.smartinvest.model.Investimento;
import br.unifor.smartinvest.service.InvestimentoService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {
	private final InvestimentoService investimentoService;

	public InvestimentoController(InvestimentoService investimentoService) {
		this.investimentoService = investimentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") Integer id) {
		return investimentoService.getById(id);
	}

	@GetMapping("/clientes/{cliente_id}/{compartilhado}")
	public ResponseEntity getByClienteId(@PathVariable("cliente_id") Integer cliente_id, @PathVariable("compartilhado") boolean compartilhado) {

		return investimentoService.getInvestimentosByClienteId(cliente_id, compartilhado);
	}

	@GetMapping("/clientes/{cliente_id}/corretoras/{corretora_id}")
	public ResponseEntity getAllInvestimentosFromClienteInCorretora(@PathVariable("cliente_id") Integer cliente_id, @PathVariable("corretora_id") Integer corretora_id) {
		return investimentoService.getAllInvestimentosFromClienteInCorretora(cliente_id, corretora_id);
	}

	@PostMapping
	public ResponseEntity addInvestiment(@RequestBody Investimento investimento) {
		return investimentoService.addInvestimento(investimento);
	}

	@PutMapping("/{id}")
	public ResponseEntity updateInvestiment(@PathVariable("id") Integer id, @RequestBody Investimento investimento) {
		return investimentoService.updateInvestimento(id, investimento);
	}

	// Filtrar investimento pelo id do cliente

	// Filtrar investimento pelo id do cliente e id de corretora

	// Simular a inserção de um histórico resultante de uma transação entre cliente e corretora em um investimento

	// Remover um investimento ao buscar pelo seu próprio id

	// Adicionar histórico em investimento
	@PostMapping("/{id}/historicos")
	public ResponseEntity addHistoricoInInvestimento(@PathVariable("id") Integer id, @RequestBody Historico historico) {
		return investimentoService.addHistoricoInInvestimento(id, historico);
	}
}