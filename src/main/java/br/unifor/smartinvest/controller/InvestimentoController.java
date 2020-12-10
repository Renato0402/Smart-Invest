package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Historico;
import br.unifor.smartinvest.model.Investimento;
import br.unifor.smartinvest.service.InvestimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {
	private final InvestimentoService investimentoService;

	public InvestimentoController(InvestimentoService investimentoService) {
		this.investimentoService = investimentoService;
	}

	@GetMapping()
	public ResponseEntity getAll() {
		return investimentoService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") int id) {
		return investimentoService.getById(id);
	}

	@PostMapping
	public ResponseEntity addInvestiment(@RequestBody Investimento investimento) {
		return investimentoService.addInvestimento(investimento);
	}

	@PutMapping("/{id}")
	public ResponseEntity updateInvestiment(@PathVariable("id") int id, @RequestBody Investimento investimento) {
		return investimentoService.updateInvestimento(id, investimento);
	}

	// Filtrar investimento pelo id do cliente

	// Filtrar investimento pelo id do cliente e id de corretora

	// Simular a inserção de um histórico resultante de uma transação entre cliente e corretora em um investimento

	// Remover um investimento ao buscar pelo seu próprio id

	// Adicionar histórico em investimento
	@PostMapping("/{id}/historicos")
	public ResponseEntity addHistoricoInInvestimento(@PathVariable("id") int id, @RequestBody Historico historico) {
		return investimentoService.addHistoricoInInvestimento(id, historico);
	}
}