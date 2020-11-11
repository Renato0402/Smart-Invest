package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Corretora;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/corretoras")
public class CorretoraController {
	private ArrayList<Corretora> listaCorretoras;

	public CorretoraController() {
		this.listaCorretoras = new ArrayList<>();
	}

	// Mostrar todas as corretoras
	@GetMapping
	public ResponseEntity<ArrayList<Corretora>> get() {

		return ResponseEntity.ok(this.listaCorretoras);
	}

	// Mostrar uma corretora ao buscar pelo seu id
	@GetMapping("/{id}")
	public ResponseEntity<Corretora> get(@PathVariable("id") int id) {
		Corretora corretora = this.buscarCorretoraPorId(id);

		if(corretora != null)
			return ResponseEntity.ok(corretora);

		return ResponseEntity.badRequest().body(null);
	}

	// Adicionar uma corretora
	@PostMapping
	public ResponseEntity<String> post(@RequestBody Corretora corretora) {
		if (adicionarCorretora(corretora))
			return ResponseEntity.ok("Corretora cadastrada com sucesso!");

		return ResponseEntity.badRequest().body("Erro ao cadastrar corretora!");
	}

	// Modificar uma corretora ao buscar pelo seu id
	@PutMapping("{id}")
	public ResponseEntity<String> put(@PathVariable int id, @RequestBody Corretora corretora) {
		if(modificarCorretora(id, corretora))
			return ResponseEntity.ok("Modificação de corretora realizada com sucesso!");

		return ResponseEntity.badRequest().body("Erro ao modificar corretora!");
	}

	// Remover uma corretora ao buscar pelo seu id
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if(removerCorretora(id))
			return ResponseEntity.ok("Remoção de corretora realizada com sucesso!");

		return ResponseEntity.badRequest().body("Erro ao remover corretora!");
	}

	//// Funções
	private boolean adicionarCorretora(Corretora corretora) {
		for(Corretora c: listaCorretoras)
			if(corretora.getId() == c.getId())
				return false;


		listaCorretoras.add(corretora);
		return true;
	}

	private Corretora buscarCorretoraPorId(int id) {
		for(Corretora c: listaCorretoras)
			if(c.getId() == id)
				return c;

		return null;
	}

	private boolean modificarCorretora(int id, Corretora novoCorretora) {
		Corretora antigaCorretora = buscarCorretoraPorId(id);

		if(antigaCorretora == null || novoCorretora == null)
			return false;

		int posAntigaCorretora = listaCorretoras.indexOf(antigaCorretora);
		listaCorretoras.set(posAntigaCorretora, novoCorretora);
		return true;
	}

	private boolean removerCorretora(int id) {
		Corretora corretora = buscarCorretoraPorId(id);

		if(corretora == null)
			return false;

		listaCorretoras.remove(corretora);
		return true;
	}
}
