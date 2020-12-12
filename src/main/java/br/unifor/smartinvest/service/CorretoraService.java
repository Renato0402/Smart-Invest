package br.unifor.smartinvest.service;

import br.unifor.smartinvest.model.Cliente;
import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.repository.ClienteRepository;
import br.unifor.smartinvest.repository.CorretoraRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CorretoraService {
	private final CorretoraRepository corretoraRepository;
	private final ClienteRepository clienteRepository;

	public CorretoraService(CorretoraRepository corretoraRepository, ClienteRepository clienteRepository) {
		this.corretoraRepository = corretoraRepository;
		this.clienteRepository = clienteRepository;
	}


	// Atualizar corretora por id e cliente_id no corretoraRepository
	public ResponseEntity updateCorretora(Integer id, Integer cliente_id, Corretora c) {
		Optional<Corretora> corretoraOpt= corretoraRepository.findById(id);
		Optional<Cliente> clienteOpt = clienteRepository.findById(cliente_id);

		if (corretoraOpt.isPresent() && clienteOpt.isPresent()) {
			Corretora corretora = corretoraOpt.get();
			Cliente cliente = clienteOpt.get();

			double saldoCliente = cliente.getSaldo();
			double extratoCorretora = corretora.getExtrato();
			double extratoNovaCorretora = c.getExtrato();

			if(saldoCliente >= extratoNovaCorretora && extratoCorretora + extratoNovaCorretora >= 0) {

				corretora.setNome(c.getNome());
				corretora.setExtrato(extratoCorretora + extratoNovaCorretora);
				cliente.setSaldo(saldoCliente - extratoNovaCorretora);

				corretoraRepository.save(corretora);
				return ResponseEntity.ok().build();
			}

			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.notFound().build();
	}


	// Obter todas as corretoras no corretoraRepository
	public ResponseEntity getAll() {
		return ResponseEntity.ok(corretoraRepository.findAll());
	}


	// Obter corretora por id no corretoraRepository
	public ResponseEntity getById(Integer id) {
		Optional<Corretora> corretoraOpt = corretoraRepository.findById(id);

		if(corretoraOpt.isPresent())
			return ResponseEntity.ok(corretoraOpt.get());

		return ResponseEntity.notFound().build();
	}


	// Adicionar corretora no corretoraRepository
	public ResponseEntity addCorretora(Corretora corretora) {
		try {
			Optional<Corretora> corretoraOpt = corretoraRepository.findByNomeLikeIgnoreCase(corretora.getNome());

			if (corretoraOpt.isEmpty()) {
				corretoraRepository.save(corretora);

				return ResponseEntity.ok().build();
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			System.err.println("Erro: " + e);
		}

		return ResponseEntity.badRequest().build();
	}
}