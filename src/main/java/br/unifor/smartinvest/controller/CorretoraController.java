package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.service.CorretoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/corretoras")
public class CorretoraController {
	private final CorretoraService corretoraService;

	public CorretoraController(CorretoraService corretoraService) {
		this.corretoraService= corretoraService;
	}

	@GetMapping()
	public ResponseEntity getAll() {
		return corretoraService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") Integer id) {
		return corretoraService.getById(id);
	}

	@PostMapping
	public ResponseEntity addCorretora(@RequestBody Corretora corretora) {
		return corretoraService.addCorretora(corretora);
	}

	@PutMapping("/{id}")
	public ResponseEntity updateCorretora(@PathVariable("id") Integer id, @RequestBody Corretora corretora) {
		return corretoraService.updateCorretora(id, corretora);
	}
}
