package br.com.tiacademy.apidontstarve.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.tiacademy.apidontstarve.crud.CrudController;
import br.com.tiacademy.apidontstarve.domain.Prato;
import br.com.tiacademy.apidontstarve.domain.Preco;
import br.com.tiacademy.apidontstarve.service.PratoService;
import br.com.tiacademy.apidontstarve.service.PrecoService;

@RestController
@RequestMapping("/prato")
public class PratoController extends CrudController<Prato, Long>{

    @Autowired
    protected PratoService pratoService;

    @Autowired
    protected PrecoService precoService;

    @GetMapping("/search={nome}")
    public ResponseEntity<List<Preco>> listarRestaurantesPrecos(@PathVariable("nome") String prato){
        Prato pratoRecuperado = pratoService.consultaPeloNome(prato);
        if(Objects.isNull(pratoRecuperado)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<Preco> precoRecuperado = precoService.findByIdPrato(pratoRecuperado);
        return ResponseEntity.ok(precoRecuperado);
    }
}