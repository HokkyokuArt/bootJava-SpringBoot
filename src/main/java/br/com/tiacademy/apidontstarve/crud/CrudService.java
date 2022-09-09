package br.com.tiacademy.apidontstarve.crud;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class CrudService<T,ID> {
    @Autowired
    protected CrudRepository<T,ID> repository;

    public Page<T> paginada(Pageable pageable){
        return repository.findAll(pageable);
    }

     public T listar_porId(ID id) {
        return repository.findById(id).orElse(null);
    }

    public T criar(T entidade) {
        return repository.save(entidade);
    }

    public void excluir(ID id) {
        var pessoa = listar_porId(id);

        if (Objects.isNull(pessoa)) {
            throw new RuntimeException("Não encontrado");
        }
        repository.deleteById(id);
    }

    public T editar(ID id, T entidade) {
        var recuperado = listar_porId(id);
        if (Objects.isNull(recuperado)) {
            throw new RuntimeException("Não encontrado");
        }

        var entidadeEditada = editarEntidade(recuperado, entidade);

        return repository.save(entidadeEditada);
    }

    protected abstract T editarEntidade(T recuperado, T entidade);
}