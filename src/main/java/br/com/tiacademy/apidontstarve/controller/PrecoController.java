package br.com.tiacademy.apidontstarve.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tiacademy.apidontstarve.crud.CrudController;
import br.com.tiacademy.apidontstarve.domain.Preco;
import br.com.tiacademy.apidontstarve.service.PrecoService;

@RestController
@RequestMapping("/preco")
public class PrecoController extends CrudController<Preco, Long> {
    public PrecoService getService(){
        return (PrecoService) this.service;
    }
    
    @PostMapping("/atribuir")
    public ResponseEntity<Preco> atribuirPreco(@RequestBody Preco entidade) {
        var salvo = getService().atribuirPreco(entidade, entidade.getIdRestaurante(), entidade.getIdPrato());
        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
        var uri = builder.path("/{id}").buildAndExpand(salvo.getId()).toUri();
        return ResponseEntity.created(uri).body(salvo);
    }
}