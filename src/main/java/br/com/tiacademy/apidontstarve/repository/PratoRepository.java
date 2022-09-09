package br.com.tiacademy.apidontstarve.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.apidontstarve.crud.CrudRepository;
import br.com.tiacademy.apidontstarve.domain.Prato;

@Repository
public interface PratoRepository extends CrudRepository<Prato, Long>{
    
}