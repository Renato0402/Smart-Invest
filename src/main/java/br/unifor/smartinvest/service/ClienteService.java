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


	// Atualizar cliente por id no clienteRepository
	public ResponseEntity updateClient(Integer id, Cliente cliente) {
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


	// Obter todos os cliente no clienteRepository
	public ResponseEntity getAll() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}


	// Obter cliente por id no clienteRepository
	public ResponseEntity getById(Integer id) {
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);

		if(clienteOpt.isPresent())
			return ResponseEntity.ok(clienteOpt.get());

		return ResponseEntity.notFound().build();
	}


	// Adicionar um cliente no clienteRepository
	public ResponseEntity addClient(Cliente cliente) {
		try {

			clienteRepository.save(cliente);
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			System.err.println("Erro: " + e);
		}

		return ResponseEntity.badRequest().build();
	}
}
