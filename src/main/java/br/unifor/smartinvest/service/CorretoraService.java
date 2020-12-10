package br.unifor.smartinvest.service;

import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.repository.CorretoraRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CorretoraService {
	private final CorretoraRepository corretoraRepository;

	public CorretoraService(CorretoraRepository corretoraRepository) {
		this.corretoraRepository = corretoraRepository;
	}

	public ResponseEntity updateCorretora(int id, Corretora corretora) {
		Optional<Corretora> corretoraExistente = corretoraRepository.findById(id);

		if (corretoraExistente.isPresent()) {
			Corretora c = corretoraExistente.get();

			c.setNome(corretora.getNome());
			c.setExtrato(corretora.getExtrato());

			corretoraRepository.save(c);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity getAll() {
		return ResponseEntity.ok(corretoraRepository.findAll());
	}

	public ResponseEntity getById(int id) {
		Optional<Corretora> corretoraOpt = corretoraRepository.findById(id);
		if(corretoraOpt.isPresent())
			return ResponseEntity.ok(corretoraOpt.get());

		return ResponseEntity.notFound().build();
	}


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
