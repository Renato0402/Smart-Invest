package br.unifor.smartinvest.service;

import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.model.Historico;
import br.unifor.smartinvest.model.Investimento;
import br.unifor.smartinvest.repository.CorretoraRepository;
import br.unifor.smartinvest.repository.HistoricoRepository;
import br.unifor.smartinvest.repository.InvestimentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvestimentoService{
	private final InvestimentoRepository investimentoRepository;
	private final HistoricoRepository historicoRepository;
	private final CorretoraRepository corretoraRepository;

	public InvestimentoService(
			InvestimentoRepository investimentoRepository,
			HistoricoRepository historicoRepository,
			CorretoraRepository corretoraRepository
	) {
		this.investimentoRepository = investimentoRepository;
		this.historicoRepository = historicoRepository;
		this.corretoraRepository = corretoraRepository;
	}

	public ResponseEntity updateInvestimento(int id, Investimento investimento) {
		Optional<Investimento> investimentoExistente = investimentoRepository.findById(id);

		if (investimentoExistente.isPresent()) {
			Investimento inv = investimentoExistente.get();

			inv.setNome(investimento.getNome());
			inv.cliente_id = investimento.cliente_id;
			inv.corretora_id = investimento.corretora_id;

			investimentoRepository.save(inv);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity getAll() {
		return ResponseEntity.ok(investimentoRepository.findAll());
	}

	public ResponseEntity getById(int id) {
		Optional<Investimento> investimentoOpt = investimentoRepository.findById(id);
		if(investimentoOpt.isPresent())
			return ResponseEntity.ok(investimentoOpt.get());

		return ResponseEntity.notFound().build();
	}


	public ResponseEntity addInvestimento(Investimento investimento) {
		try {

			investimentoRepository.save(investimento);
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			System.err.println("Erro: " + e);
		}

		return ResponseEntity.badRequest().build();
	}

	public ResponseEntity addHistoricoInInvestimento(int id, Historico historico) {
		// Obter cliente pelo investimento e depois comparar com historico
		Optional<Investimento> investimentoOpt = this.investimentoRepository.findById(id);
		if(investimentoOpt.isPresent()) {
			Corretora corretora = investimentoOpt.get().corretora_id;
//			Corretora corretora = corretoraRepository.getOne(corretora);

			if(corretora.getExtrato() >= historico.getValorInvestido()) {
				historico.setInvestimento_id(id);
				corretora.setExtrato(corretora.getExtrato() - historico.getValorInvestido());

				investimentoRepository.save(investimentoOpt.get());
				corretoraRepository.save(corretora);
				historicoRepository.save(historico);

				return ResponseEntity.ok().build();
			}
		}

		return ResponseEntity.badRequest().build();
	}
}
