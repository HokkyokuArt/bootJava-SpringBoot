package br.com.tiacademy.apidontstarve.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.apidontstarve.crud.CrudRepository;
import br.com.tiacademy.apidontstarve.domain.Prato;

@Repository
public interface PratoRepository extends CrudRepository<Prato, Long>{
    @Query(value = "select p from Prato p where p.nome = :nome")
    Prato consultaPeloNome(@Param("nome") String nome);
}