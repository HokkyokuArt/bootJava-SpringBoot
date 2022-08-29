package br.com.tiacademy.catalogo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.catalogo.dto.ArtistaDTO;
import br.com.tiacademy.catalogo.dto.GravadoraDTO;
import br.com.tiacademy.catalogo.entity.Gravadora;
import lombok.var;

@RestController
@RequestMapping("/gravadora")
public class GravadoraController extends ControllerCatalago<Gravadora, Long> {

    @GetMapping("/dto")
    public ResponseEntity<List<GravadoraDTO>> listaDto(){
        var gravadoras = repository.findAll();
        var gravadorasDto = gravadoras.stream().map(gravadora -> new GravadoraDTO(
                gravadora.getId(),
                gravadora.getNome(),
                gravadora.getAno(),
                gravadora.getCidade(),
                gravadora.getUf(),
                gravadora.getArtista().stream()
                    .map(artista -> new ArtistaDTO(artista.getId(), artista.getNome()))
                    .collect(Collectors.toList())
            )
        ).collect(Collectors.toList());

        return ResponseEntity.ok(gravadorasDto);
    }
} 