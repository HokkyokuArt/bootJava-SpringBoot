package br.com.tiacademy.vendas.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.vendas.core.crud.CrudRepository;
import br.com.tiacademy.vendas.domain.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
    
}