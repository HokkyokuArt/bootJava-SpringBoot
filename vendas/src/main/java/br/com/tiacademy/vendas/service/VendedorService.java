package br.com.tiacademy.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.repository.VendedorRepository;

@Service 
public class VendedorService {    
    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> listar(){
        return vendedorRepository.findAll();
    }

    public Vendedor porId(Long id){
        return vendedorRepository.findById(id).orElse(null);
    }
    
}