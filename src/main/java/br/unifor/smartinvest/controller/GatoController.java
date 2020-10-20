package br.unifor.smartinvest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gatos")
public class GatoController {

	@GetMapping
	public int get() {
		return (int)(Math.random() * 100);
	}

	@PostMapping
	public void post(@RequestParam String dados) {
		System.out.println("Dados: ");
		System.out.println(dados);
	}
}
