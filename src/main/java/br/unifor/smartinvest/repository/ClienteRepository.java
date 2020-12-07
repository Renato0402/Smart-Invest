package br.unifor.smartinvest.repository;

import br.unifor.smartinvest.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}