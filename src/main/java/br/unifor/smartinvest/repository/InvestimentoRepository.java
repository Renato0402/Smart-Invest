package br.unifor.smartinvest.repository;

import br.unifor.smartinvest.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Integer> {
}