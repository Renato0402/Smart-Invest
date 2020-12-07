package br.unifor.smartinvest.model;

import javax.persistence.*;

@Entity
@Table(name="CLIENTES")
public class Cliente{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private double saldo;

	// Para compartilhar com outro usuário, utilizar o id
	public Cliente() {	}

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

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}