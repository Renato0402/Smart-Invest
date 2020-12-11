package br.unifor.smartinvest.service;

import br.unifor.smartinvest.model.Cliente;
import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.model.Historico;
import br.unifor.smartinvest.model.Investimento;
import br.unifor.smartinvest.repository.HistoricoRepository;
import br.unifor.smartinvest.repository.InvestimentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService{
	private final InvestimentoRepository investimentoRepository;
	private final HistoricoRepository historicoRepository;

	public InvestimentoService(
			InvestimentoRepository investimentoRepository,
			HistoricoRepository historicoRepository
	) {
		this.investimentoRepository = investimentoRepository;
		this.historicoRepository = historicoRepository;
	}

	public ResponseEntity updateInvestimento(Integer id, Investimento investimento) {
		Optional<Investimento> investimentoExistente = investimentoRepository.findById(id);

		if (investimentoExistente.isPresent()) {
			Investimento inv = investimentoExistente.get();

			inv.setNome(investimento.getNome());
			inv.setCliente(investimento.getCliente());
			inv.setCorretora(investimento.getCorretora());

			investimentoRepository.save(inv);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity getById(Integer id) {
		Optional<Investimento> investimentoOpt = investimentoRepository.findById(id);
		if(investimentoOpt.isPresent())
			return ResponseEntity.ok(investimentoOpt.get());

		return ResponseEntity.notFound().build();
	}

	public ResponseEntity getInvestimentosByClienteId(Integer cliente_id, boolean compartilhado) {
		try {
			List<Object> investimentos;

			if(compartilhado) {
				investimentos = investimentoRepository.getInvestimentoByClienteIdShared(cliente_id);
			} else {
				investimentos = investimentoRepository.getInvestimentoByClienteId(cliente_id);
			}

			System.out.println(investimentos);

			return ResponseEntity.ok(investimentos);
		} catch (Exception e) {
			System.err.println("Erro: " + e);
		}

		return ResponseEntity.badRequest().build();
	}

	public ResponseEntity getAllInvestimentosFromClienteInCorretora(Integer cliente_id, Integer corretora_id) {
		try {

			List<Investimento> corretorasOpt = investimentoRepository.getAllInvestimentosFromClienteInCorretora(cliente_id, corretora_id);
			return ResponseEntity.ok(corretorasOpt);

		} catch (Exception e) {
			System.err.println("Erro: " + e);
		}

		return ResponseEntity.badRequest().build();
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

	public ResponseEntity addHistoricoInInvestimento(Integer id, Historico historico) {
		// Obter cliente pelo investimento e depois comparar com historico
		Optional<Investimento> investimentoOpt = this.investimentoRepository.findById(id);
		if(investimentoOpt.isPresent()) {
			Investimento investimento = investimentoOpt.get();
			Corretora corretora = investimento.getCorretora();

			if(corretora.getExtrato() >= historico.getValorInvestido()) {
				historico.setInvestimento(investimento);

				corretora.setExtrato(corretora.getExtrato() - historico.getValorInvestido());

				investimentoRepository.save(investimento);
				historicoRepository.save(historico);

				return ResponseEntity.ok().build();
			}
		}

		return ResponseEntity.badRequest().build();
	}
}
