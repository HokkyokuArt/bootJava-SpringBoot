package br.com.tiacademy.vendas.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar_todosClientes() {
        var resultado = clienteService.listar_todosClientes();

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listar_ClientePorId(@PathVariable("id") Long id) {
        var resultado = clienteService.listar_clientePorId(id);
        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Cliente> criar_cliente(@RequestBody Cliente cliente) {
        var clienteCriado = clienteService.criar_cliente(cliente);
        return ResponseEntity.ok(clienteCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editar_cliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        var clienteEditado = clienteService.editar_cliente(id, cliente);
        return ResponseEntity.ok(clienteEditado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir_cliente(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clienteService.excluir_cliente(id));
    }
}