package br.unifor.smartinvest.repository;

import br.unifor.smartinvest.model.Corretora;
import br.unifor.smartinvest.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CorretoraRepository extends JpaRepository<Corretora, Integer> {

	Optional<Corretora> findByNomeLikeIgnoreCase(String id);


}