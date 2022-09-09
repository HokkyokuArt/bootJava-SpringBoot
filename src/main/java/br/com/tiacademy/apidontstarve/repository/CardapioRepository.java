package br.com.tiacademy.apidontstarve.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.apidontstarve.crud.CrudRepository;
import br.com.tiacademy.apidontstarve.domain.Cardapio;

@Repository
public interface CardapioRepository extends CrudRepository<Cardapio, Long> {

}