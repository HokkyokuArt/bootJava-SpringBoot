package br.com.tiacademy.vendas.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.vendas.core.crud.CrudService;
import br.com.tiacademy.vendas.domain.Pedido;

@Service
public class PedidoService extends CrudService<Pedido, Long> {

    @Override
    protected Pedido editarEntidade(Pedido recuperado, Pedido entidade) {
       recuperado.setId(entidade.getId());
       recuperado.setValor(entidade.getValor());
       recuperado.setData(entidade.getData());
       recuperado.setCliente(entidade.getCliente());
       recuperado.setVendedor(entidade.getVendedor());
       return recuperado;
    }

}