package br.unifor.smartinvest.repository;

import br.unifor.smartinvest.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Integer> {

	//? Obter os investimentos de clientes que estão compartilhando e o id que foi buscado dentro da url
	@Query("SELECT DISTINCT I FROM Investimento I " +
			"INNER JOIN I.cliente " +
			"WHERE I.cliente.compartilhado = TRUE OR I.cliente.id = :cliente_id")
	List<Object> getInvestimentoByClienteIdShared(Integer cliente_id);


	//? Obter apenas os investimentos pelo cliente id
	List<Object> getInvestimentoByClienteId(Integer cliente_id);


	//? Obter todos os investimentos por corretora_id e cliente_id
	@Query(
			("SELECT DISTINCT I FROM Investimento I " +
					"WHERE I.cliente.id = :cliente_id AND I.corretora.id = :corretora_id")
	)
	List<Investimento> getAllInvestimentosFromClienteInCorretora(Integer cliente_id, Integer corretora_id);
}