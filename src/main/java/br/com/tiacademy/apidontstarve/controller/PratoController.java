package br.com.tiacademy.apidontstarve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.apidontstarve.crud.CrudController;
import br.com.tiacademy.apidontstarve.domain.Prato;

@RestController
@RequestMapping("/prato")
public class PratoController extends CrudController<Prato, Long>{
    @GetMapping
    public String teste(){
        return "Teste Prato";
    }
}