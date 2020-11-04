package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Corretora;
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
	public ArrayList<Corretora> get() {
		return this.listaCorretoras;
	}

	// Mostrar uma corretora ao buscar pelo seu id
	// Ex.: localhost:8080/corretoras/1
	@GetMapping("/{id}")
	public Corretora get(@PathVariable("id") int id) {
		Corretora corretora = this.buscarCorretoraPorId(id);

		return corretora;
	}

	// Adicionar uma corretora
	@PostMapping
	public String post(@RequestBody Corretora corretora) {
		if (adicionarCorretora(corretora))
			return "Corretora cadastrada com sucesso!";

		return "Erro ao cadastrar corretora!";
	}

	// Modificar uma corretora ao buscar pelo seu id
	@PutMapping
	public String put(@RequestHeader int id, @RequestBody Corretora corretora) {
		if(modificarCorretora(id, corretora))
			return "Modificação de corretora realizada com sucesso!";

		return "Erro ao modificar corretora!";
	}

	// Remover uma corretora ao buscar pelo seu id
	@DeleteMapping
	public String delete(@RequestHeader int id) {
		if(removerCorretora(id))
			return "Remoção de corretora realizada com sucesso!";

		return "Erro ao remover corretora!";
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

		if(antigaCorretora != null && novoCorretora != null) {
			int posAntigaCorretora = listaCorretoras.indexOf(antigaCorretora);
			listaCorretoras.set(posAntigaCorretora, novoCorretora);
			return true;
		}

		return false;
	}

	private boolean removerCorretora(int id) {
		Corretora corretora = buscarCorretoraPorId(id);

		if(corretora != null) {
			listaCorretoras.remove(corretora);
			return true;
		}

		return false;
	}
}
