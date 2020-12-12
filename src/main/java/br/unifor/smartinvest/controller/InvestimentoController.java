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


	// Obter investimento por id
	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") Integer id) {
		return investimentoService.getById(id);
	}


	// Obter investimento por id de cliente (compartilhamento definido por variável em url 'clientes/id/')
	@GetMapping({"/clientes/{cliente_id}", "/clientes/{cliente_id}/{compartilhado}"})
	public ResponseEntity getByClienteId(
			@PathVariable("cliente_id") Integer cliente_id,
			@PathVariable(value = "compartilhado", required = false) boolean compartilhado
	) {
		return investimentoService.getInvestimentosByClienteId(cliente_id, compartilhado);
	}


	// Obter todos investimentos de um cliente realizados em uma determinada corretora
	@GetMapping("/clientes/{cliente_id}/corretoras/{corretora_id}")
	public ResponseEntity getAllInvestimentosFromClienteInCorretora(@PathVariable("cliente_id") Integer cliente_id, @PathVariable("corretora_id") Integer corretora_id) {
		return investimentoService.getAllInvestimentosFromClienteInCorretora(cliente_id, corretora_id);
	}


	// Adicionar investimento
	@PostMapping
	public ResponseEntity addInvestiment(@RequestBody Investimento investimento) {
		return investimentoService.addInvestimento(investimento);
	}


	// Adicionar histórico em investimento
	@PostMapping("/{id}/historicos")
	public ResponseEntity addHistoricoInInvestimento(@PathVariable("id") Integer id, @RequestBody Historico historico) {
		return investimentoService.addHistoricoInInvestimento(id, historico);
	}


	// Atualizar investimento por id
	@PutMapping("/{id}")
	public ResponseEntity updateInvestiment(@PathVariable("id") Integer id, @RequestBody Investimento investimento) {
		return investimentoService.updateInvestimento(id, investimento);
	}
}