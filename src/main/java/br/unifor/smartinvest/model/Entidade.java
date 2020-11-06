package br.unifor.smartinvest.model;

public abstract class Entidade {
	protected int id;
	protected String nome;

	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
