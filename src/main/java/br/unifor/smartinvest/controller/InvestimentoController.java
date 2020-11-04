package br.unifor.smartinvest.controller;

import br.unifor.smartinvest.model.Investimento;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {
	private ArrayList<Investimento> listaInvestimentos;

	public InvestimentoController() {
		this.listaInvestimentos = new ArrayList<>();
	}

	// Mostrar todos os investimentos
	@GetMapping
	public ArrayList<Investimento> get() {
		return this.listaInvestimentos;
	}

	// Mostrar investimentos ao buscar pelo seu id
	// Ex.: localhost:8080/investimentos/1
	@GetMapping("/{id}")
	public ArrayList<Investimento> get(@PathVariable("id") int id) {
		ArrayList<Investimento> investimentos = this.buscarTodosInvestimentosPorClienteId(id);

		return investimentos;
	}

	// Adicionar um investimento
	@PostMapping
	public String post(@RequestBody Investimento investimento) {
		if (adicionarInvestimento(investimento))
			return "Investimento cadastrado com sucesso!";

		return "Erro ao cadastrar investimento!";
	}

	// Remover um investimento ao buscar pelo seu id
	@DeleteMapping
	public String delete(@RequestHeader int id) {
		if(removerInvestimento(id))
			return "Remoção de investimento realizada com sucesso!";

		return "Erro ao remover investimento!";
	}

	//// Funções
	private boolean adicionarInvestimento(Investimento investimento) {
		if(investimento == null)
			return false;

		listaInvestimentos.add(investimento);
		return true;
	}

	private Investimento buscarInvestimentoPorClienteId(int id) {

		for(Investimento i: listaInvestimentos)
			if(i.getCliente().getId() == id)
				return i;


		return null;
	}

	private ArrayList<Investimento> buscarTodosInvestimentosPorClienteId(int id) {
		ArrayList<Investimento> investimentos = new ArrayList<>();

		for(Investimento i: listaInvestimentos)
			if(i.getCliente().getId() == id)
				investimentos.add(i);


		return investimentos;
	}

	private boolean removerInvestimento(int id) {
		Investimento investimento = buscarInvestimentoPorClienteId(id);

		if(investimento == null)
			return false;

		listaInvestimentos.remove(investimento);
		return true;
	}
}
