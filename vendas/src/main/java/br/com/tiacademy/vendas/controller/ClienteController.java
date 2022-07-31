package br.com.tiacademy.vendas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.vendas.core.crud.CrudController;
import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.dto.ClienteDTO;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends CrudController<Cliente, ClienteDTO, Long> {

}