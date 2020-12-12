package br.unifor.smartinvest.model;

import javax.persistence.*;

@Entity
@Table(name = "investimentos")
public class Investimento{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Corretora corretora;

	public Investimento() {
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Corretora getCorretora() {
		return corretora;
	}
	public void setCorretora(Corretora corretora) {
		this.corretora = corretora;
	}
}