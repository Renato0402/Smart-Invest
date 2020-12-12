package br.unifor.smartinvest.model;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Cliente{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private double saldo;

	private boolean compartilhado;

	public Cliente() {

	}
	// Construtor alternativo necessário para evitar o erro de falta de serializer
	public Cliente(Integer id) {
		this.id = id;
	}


	public boolean isCompartilhado() {
		return compartilhado;
	}
	public void setCompartilhado(boolean compartilhado) {
		this.compartilhado = compartilhado;
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


	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}