package br.unifor.smartinvest.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVESTIMENTOS")
public class Investimento{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private int clienteId;
	private int corretoraId;

	@OneToMany(mappedBy = "valorInvestido")
	private List<Historico> historicos;

	public Investimento() {
		this.historicos = new ArrayList<>();
	}

	public void addHistorico(Historico historico) {
		if(historico == null) return;

		this.historicos.add(historico);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public int getCorretoraId() {
		return corretoraId;
	}
	public void setCorretoraId(int corretoraId) {
		this.corretoraId = corretoraId;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}
	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}
}