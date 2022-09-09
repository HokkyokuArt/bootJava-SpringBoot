package br.com.tiacademy.apidontstarve.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.apidontstarve.crud.CrudRepository;
import br.com.tiacademy.apidontstarve.domain.Prato;
import br.com.tiacademy.apidontstarve.domain.Preco;

@Repository
public interface PrecoRepository extends CrudRepository<Preco, Long> {
    List<Preco> findByIdPrato(Prato prato);
}