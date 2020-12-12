package br.unifor.smartinvest.service;

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


	// Atualizar investimento no investimentoRepository
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


	// Obter investimento por id no investimentoRepository
	public ResponseEntity getById(Integer id) {
		Optional<Investimento> investimentoOpt = investimentoRepository.findById(id);

		if(investimentoOpt.isPresent())	return ResponseEntity.ok(investimentoOpt.get());

		return ResponseEntity.notFound().build();
	}


	// Obter investimentos realizados por cliente no investimentoRepository
	public ResponseEntity getInvestimentosByClienteId(Integer cliente_id, boolean compartilhado) {
		try {
			List<Object> investimentos;

			if(compartilhado) investimentos = investimentoRepository.getInvestimentoByClienteIdShared(cliente_id);
			else investimentos = investimentoRepository.getInvestimentoByClienteId(cliente_id);

			return ResponseEntity.ok(investimentos);
		} catch (Exception e) {
			System.err.println("Erro: " + e);
		}

		return ResponseEntity.badRequest().build();
	}


	// Obter todos investimentos realizados por um cliente em uma determinada corretora no investimentoRepository
	public ResponseEntity getAllInvestimentosFromClienteInCorretora(Integer cliente_id, Integer corretora_id) {
		try {

			List<Investimento> corretorasOpt = investimentoRepository.getAllInvestimentosFromClienteInCorretora(cliente_id, corretora_id);
			return ResponseEntity.ok(corretorasOpt);

		} catch (Exception e) {
			System.err.println("Erro: " + e);
		}

		return ResponseEntity.badRequest().build();
	}


	// Adicionar investimento no investimentoRepository
	public ResponseEntity addInvestimento(Investimento investimento) {
		try {

			investimentoRepository.save(investimento);
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			System.err.println("Erro: " + e);
		}

		return ResponseEntity.badRequest().build();
	}


	// Adicionar historico em investimento por id no investimentoRepository
	public ResponseEntity addHistoricoInInvestimento(Integer id, Historico historico) {
		Optional<Investimento> investimentoOpt = this.investimentoRepository.findById(id);

		if(investimentoOpt.isPresent()) {
			Investimento investimento = investimentoOpt.get();
			Corretora corretora = investimento.getCorretora();

			double extratoCorretora = corretora.getExtrato();
			double valorNovoHistorico = historico.getValorInvestido();
			if(
					extratoCorretora >= valorNovoHistorico &&
					extratoCorretora - valorNovoHistorico >= 0
			) {
				historico.setInvestimento(investimento);
				corretora.setExtrato(extratoCorretora - valorNovoHistorico);

				investimentoRepository.save(investimento);
				historicoRepository.save(historico);

				return ResponseEntity.ok().build();
			}
		}

		return ResponseEntity.badRequest().build();
	}
}