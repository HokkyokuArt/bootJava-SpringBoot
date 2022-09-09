package br.com.tiacademy.apidontstarve.crud;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public abstract class CrudController<T extends CrudDomain<ID>,ID>{
    @Autowired
    protected CrudService<T, ID> service;

    @GetMapping
    public ResponseEntity<Page<T>> paginada(Pageable pageable){
        var listaPaginada =service.paginada(pageable);
        return ResponseEntity.ok(listaPaginada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> especifico(@PathVariable("id") ID id) {
        var entidade = service.listar_porId(id);
        if (Objects.isNull(entidade)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entidade);
    }

    @PostMapping
    public ResponseEntity<T> criar(@RequestBody T entidade) {
        var salvo = service.criar(entidade);
        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
        var uri = builder.path("/{id}").buildAndExpand(salvo.getId()).toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> editar(@PathVariable("id") ID id, @RequestBody T entidade) {
        var salvo = service.editar(id, entidade);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") ID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}