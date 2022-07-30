package br.com.tiacademy.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.tiacademy.vendas.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}