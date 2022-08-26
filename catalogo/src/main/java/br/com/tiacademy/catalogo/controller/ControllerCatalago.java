package br.com.tiacademy.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.tiacademy.catalogo.repository.RepositoryCatalago;

public abstract class ControllerCatalago<T, ID> {

    @Autowired
    protected RepositoryCatalago<T, ID> repository;

    @GetMapping
    public List<T> lista(){
        return repository.findAll();
        
    }
    

}