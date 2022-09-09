package br.com.tiacademy.apidontstarve.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.apidontstarve.crud.CrudController;
import br.com.tiacademy.apidontstarve.domain.Restaurante;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController extends CrudController<Restaurante, Long> {
}