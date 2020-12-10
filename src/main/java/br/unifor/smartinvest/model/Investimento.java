package br.unifor.smartinvest.model;

import javax.persistence.*;

@Entity
@Table(name = "investimentos")
public class Investimento{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;

	//! Se alterar o nome da variável para outro nome além de 'cliente_id', mesmo que seja um objeto do tipo 'Cliente', dá um erro sobre algum atributo não nulo se transformando em nulo
	@ManyToOne()
	@JoinColumn(name = "cliente_id")
	public Cliente cliente_id;

	@ManyToOne()
	@JoinColumn(name = "corretora_id")
	public Corretora corretora_id;

//	@OneToMany(mappedBy = "investimento_id")
//	private List<Historico> historicos;

	public Investimento() {
		/*this.historicos = new ArrayList<>();*/
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

	//	public List<Historico> getHistoricos() {
//		return historicos;
//	}
//	public void setHistoricos(List<Historico> historicos) {
//		this.historicos = historicos;
//	}
}