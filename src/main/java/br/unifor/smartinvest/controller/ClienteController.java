package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	private ArrayList<Cliente> listaClientes;

	public ClienteController() {
		this.listaClientes = new ArrayList<>();
	}

	// Mostrar todos os clientes
	@GetMapping
	public ResponseEntity<ArrayList<Cliente>> get() {

		return ResponseEntity.ok(this.listaClientes);
	}

	// Mostrar um cliente ao buscar pelo seu id
	// Ex.: localhost:8080/clientes/1
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> get(@PathVariable("id") int id) {
		Cliente cliente = this.buscarClientePorId(id);

		return ResponseEntity.ok(cliente);
	}

	// Adicionar um cliente
	@PostMapping
	public ResponseEntity<String> post(@RequestBody Cliente cliente) {
		if (adicionarCliente(cliente))
			return ResponseEntity.ok("Cliente cadastrado com sucesso!");

		return ResponseEntity.badRequest().body("Erro ao cadastrar cliente!");
	}

	// Modificar um cliente ao buscar pelo seu id
	@PutMapping("{id}")
	public ResponseEntity<String> put(@PathVariable int id, @RequestBody Cliente cliente) {
		if(modificarCliente(id, cliente))
			return ResponseEntity.ok("Modificação de cliente realizada com sucesso!");

		return ResponseEntity.badRequest().body("Erro ao modificar cliente!");
	}

	// Remover um cliente ao buscar pelo seu id
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if(removerCliente(id))
			return ResponseEntity.ok("Remoção de cliente realizada com sucesso!");

		return ResponseEntity.badRequest().body("Erro ao remover cliente!");
	}

	//// Funções
	private boolean adicionarCliente(Cliente cliente) {
		for(Cliente c: listaClientes)
			if(cliente.getId() == c.getId())
				return false;

		listaClientes.add(cliente);
		return true;
	}

	private Cliente buscarClientePorId(int id) {
		for(Cliente c: listaClientes)
			if(c.getId() == id)
				return c;

		return null;
	}

	private boolean modificarCliente(int id, Cliente novoCliente) {
		Cliente antigoCliente = buscarClientePorId(id);

		if(antigoCliente == null || novoCliente == null) return false;

		int posAntigoCliente = listaClientes.indexOf(antigoCliente);
		listaClientes.set(posAntigoCliente, novoCliente);
		return true;
	}

	private boolean removerCliente(int id) {
		Cliente cliente = buscarClientePorId(id);

		if(cliente == null) return false;

		listaClientes.remove(cliente);
		return true;
	}
}
