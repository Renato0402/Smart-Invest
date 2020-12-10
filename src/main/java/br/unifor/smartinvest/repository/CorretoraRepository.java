package br.unifor.smartinvest.repository;

import br.unifor.smartinvest.model.Corretora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CorretoraRepository extends JpaRepository<Corretora, Integer> {

	Optional<Corretora> findByNomeLikeIgnoreCase(String id);
}