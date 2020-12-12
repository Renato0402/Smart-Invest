package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.service.CorretoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/corretoras")
public class CorretoraController {
	private final CorretoraService corretoraService;


	public CorretoraController(CorretoraService corretoraService) {
		this.corretoraService = corretoraService;
	}


	// Obter todas as corretoras
	@GetMapping()
	public ResponseEntity getAll() {
		return corretoraService.getAll();
	}


	// Obter uma corretora por id
	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") Integer id) {
		return corretoraService.getById(id);
	}


	// Adicionar uma corretora
	@PostMapping
	public ResponseEntity addCorretora(@RequestBody Corretora corretora) {
		return corretoraService.addCorretora(corretora);
	}


	// Atualizar um corretora por id
	@PutMapping("/{id}/clientes/{cliente_id}")
	public ResponseEntity updateCorretora(
			@PathVariable("id") Integer id,
			@PathVariable("cliente_id") Integer cliente_id,
			@RequestBody Corretora corretora
	) {
		return corretoraService.updateCorretora(id, cliente_id, corretora);
	}
}