package br.com.tiacademy.apidontstarve.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.apidontstarve.crud.CrudService;
import br.com.tiacademy.apidontstarve.domain.Prato;

@Service
public class PratoService extends CrudService<Prato, Long>{
    @Override
    protected Prato editarEntidade(Prato recuperado, Prato entidade){
        recuperado.setNome(entidade.getNome());
        return recuperado;
    }
}