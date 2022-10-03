package br.com.tiacademy.vendas.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.vendas.core.crud.CrudConverter;
import br.com.tiacademy.vendas.domain.Pedido;
import br.com.tiacademy.vendas.dto.PedidoDTO;
import br.com.tiacademy.vendas.repository.ClienteRepository;
import br.com.tiacademy.vendas.repository.VendedorRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PedidoConverter implements CrudConverter<Pedido, PedidoDTO> {
    private final ClienteConverter clienteConverter;
    private final VendedorConverter vendedorConverter;
    private final ClienteRepository clienteRepository;
    private final VendedorRepository vendedorRepository;


    @Override
    public PedidoDTO entidadeParaDto(Pedido entidade) {
       var dto = new PedidoDTO();
       dto.setId(entidade.getId());
       dto.setData(entidade.getData());
       dto.setValor(entidade.getValor());
       dto.setCliente(clienteConverter.entidadeParaDto(entidade.getCliente()));
       dto.setVendedor(vendedorConverter.entidadeParaDto(entidade.getVendedor()));

       return dto;
    }

    @Override
    public Pedido dtoParaEntidade(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setId(dto.getId());
        pedido.setData(dto.getData());
        pedido.setValor(dto.getValor());
        pedido.setCliente(clienteRepository.findById(dto.getClienteId()).orElse(null));
        pedido.setVendedor(vendedorRepository.findById(dto.getVendedorId()).orElse(null));

        return pedido;
    }

}