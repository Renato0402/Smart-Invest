package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Cliente;
import br.unifor.smartinvest.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	private final ClienteService clienteService;


	public ClienteController(ClienteService clienteService) {
		this.clienteService= clienteService;
	}


	// Obter todos os clientes
	@GetMapping()
	public ResponseEntity getAll() {
		return clienteService.getAll();
	}


	// Obter cliente por id
	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") Integer id) {
		return clienteService.getById(id);
	}


	// Adicionar cliente
	@PostMapping
	public ResponseEntity addClient(@RequestBody Cliente cliente) {
		return clienteService.addClient(cliente);
	}


	// Atualizar cliente por id
	@PutMapping("/{id}")
	public ResponseEntity updateClient(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		return clienteService.updateClient(id, cliente);
	}
}