package br.unifor.smartinvest.service;

import br.unifor.smartinvest.model.Cliente;
import br.unifor.smartinvest.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public ResponseEntity updateClient(int id, Cliente cliente) {
		Optional<Cliente> clienteExistente = clienteRepository.findById(id);

		if (clienteExistente.isPresent()) {
			Cliente c = clienteExistente.get();

			c.setNome(cliente.getNome());
			c.setSaldo(cliente.getSaldo());

			clienteRepository.save(c);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity getAll() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

	public ResponseEntity getById(int id) {
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);
		if(clienteOpt.isPresent())
			return ResponseEntity.ok(clienteOpt.get());

		return ResponseEntity.notFound().build();
	}


	public ResponseEntity addClient(Cliente cliente) {
		try {

			Optional<Cliente> clienteOpt = clienteRepository.findById(cliente.getId());
			if (clienteOpt.isEmpty()) clienteRepository.save(cliente);

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			System.err.println("Erro: " + e);
		}

		return ResponseEntity.badRequest().build();
	}
}
