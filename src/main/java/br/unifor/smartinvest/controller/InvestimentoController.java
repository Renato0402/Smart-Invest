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

	@GetMapping
	public ArrayList<Investimento> get() {
		return listaInvestimentos;
	}

	@GetMapping("/{id}")
	public Investimento get(@PathVariable("id") int id) {
		Investimento investimento = buscarInvestimentoPorClienteId(id);
		if(investimento != null)
			return investimento;

		return null;
	}

	@PostMapping
	public String post(@RequestBody Investimento investimento) {
		if(investimento != null) {
			this.listaInvestimentos.add(investimento);
			return "Investimento realizado com sucesso!";
		}

		return "Erro ao investir!";
	}

	@PutMapping
	public String put(@RequestHeader int id, @RequestBody Investimento investimento) {
		if(alterarClientePorId(id, investimento))
			return "Alteração de investimento realizada com sucesso!";

		return "Não foi encontrado um investimento realizado por este cliente!";
	}

	@DeleteMapping
	public String delete(@RequestHeader int id) {
		if(removerClientePorId(id))
			return "Remoção de investimento realizada com sucesso!";

		return "Não foi encontrado um investimento realizado por este cliente!";
	}

	private Investimento buscarInvestimentoPorClienteId(int id) {
		for (Investimento listaInvestimento : listaInvestimentos)
			if (listaInvestimento.getCliente().getClienteId() == id)
				return listaInvestimento;


		return null;
	}

	private boolean alterarClientePorId(int id, Investimento novoInvestimento) {
		Investimento antigoInvestimento = this.buscarInvestimentoPorClienteId(id);
		if(antigoInvestimento != null && novoInvestimento != null) {
			int posAntigoInvestimento = listaInvestimentos.indexOf(antigoInvestimento);
			listaInvestimentos.set(posAntigoInvestimento, novoInvestimento);
			return true;
		}

		return false;
	}

	private boolean removerClientePorId(int id) {
		Investimento investimento = this.buscarInvestimentoPorClienteId(id);
		if(investimento != null) {
			listaInvestimentos.remove(investimento);
			return true;
		}

		return false;
	}
}