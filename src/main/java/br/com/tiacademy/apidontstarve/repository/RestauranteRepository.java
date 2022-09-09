package br.com.tiacademy.apidontstarve.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.apidontstarve.crud.CrudRepository;
import br.com.tiacademy.apidontstarve.domain.Restaurante;

@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Long>{
    
}