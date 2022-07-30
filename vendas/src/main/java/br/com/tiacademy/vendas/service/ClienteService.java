package br.com.tiacademy.vendas.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar_todosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente listar_clientePorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente criar_cliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente editar_cliente(Long id, Cliente clienteEditado) {
        var cliente = listar_clientePorId(id);

        if (Objects.isNull(cliente)) {
            throw new RuntimeException("Cliente não encontrado");
        }

        cliente.setNome(clienteEditado.getNome());

        return clienteRepository.save(cliente);

    }

    public String excluir_cliente(Long id) {
        if (Objects.isNull(listar_clientePorId(id))) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
        return "Cliente " + id + " excluído com sucesso!!!";
    }
}