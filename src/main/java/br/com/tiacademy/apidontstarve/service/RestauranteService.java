package br.com.tiacademy.apidontstarve.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.apidontstarve.crud.CrudService;
import br.com.tiacademy.apidontstarve.domain.Restaurante;

@Service
public class RestauranteService extends CrudService<Restaurante, Long>{
    @Override
    protected Restaurante editarEntidade(Restaurante recuperado, Restaurante entidade){
        recuperado.setNome(entidade.getNome());
        recuperado.setCozinha(entidade.getCozinha());
        recuperado.setEndereco(entidade.getEndereco());
        recuperado.setEntrega(entidade.getEntrega());
        return recuperado;
    }
}