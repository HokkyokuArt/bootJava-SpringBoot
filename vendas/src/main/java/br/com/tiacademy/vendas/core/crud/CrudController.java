package br.com.tiacademy.vendas.core.crud;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

public abstract class CrudController<T extends CrudDomain<ID>, D, ID> {
    @Autowired
    protected CrudService<T, ID> service;

    @Autowired CrudConverter<T,D> converter;

    @GetMapping
    public ResponseEntity<Page<D>> paginada(Pageable pageable){
        var listaPaginada =service.paginada(pageable).map(converter::entidadeParaDto);
        return ResponseEntity.ok(listaPaginada);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<D>> listar() {
        var listaDto = service.listar().stream().map(converter::entidadeParaDto).collect(Collectors.toList());
        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> especifico(@PathVariable("id") ID id) {
        var entidade = service.listar_porId(id);
        if (Objects.isNull(entidade)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(converter.entidadeParaDto(entidade));
    }

    @PostMapping
    public ResponseEntity<D> criar(@RequestBody D dto) {
        var entidade = converter.dtoParaEntidade(dto);
        var salvo = service.criar(entidade);
        
        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
        var uri = builder.path("/{id}").buildAndExpand(salvo.getId()).toUri();

        return ResponseEntity.created(uri).body(converter.entidadeParaDto(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> editar(@PathVariable("id") ID id, @RequestBody D dto) {
        var novaEntidade = converter.dtoParaEntidade(dto);
        var salvo = service.editar(id, novaEntidade);
        return ResponseEntity.ok(converter.entidadeParaDto(salvo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") ID id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}