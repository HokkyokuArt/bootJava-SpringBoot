package br.com.tiacademy.apidontstarve.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiacademy.apidontstarve.crud.CrudService;
import br.com.tiacademy.apidontstarve.domain.Prato;
import br.com.tiacademy.apidontstarve.domain.Preco;
import br.com.tiacademy.apidontstarve.domain.Restaurante;
import br.com.tiacademy.apidontstarve.repository.PratoRepository;
import br.com.tiacademy.apidontstarve.repository.PrecoRepository;
import br.com.tiacademy.apidontstarve.repository.RestauranteRepository;

@Service
public class PrecoService extends CrudService<Preco, Long> {
    public PrecoRepository getRepository() {
        return (PrecoRepository) this.repository;
    }

    @Autowired
    protected RestauranteRepository restauranteRepository;

    @Autowired
    protected PratoRepository pratoRepository;

    @Override
    protected Preco editarEntidade(Preco recuperado, Preco entidade) {
        recuperado.setIdRestaurante(entidade.getIdRestaurante());
        recuperado.setIdPrato(entidade.getIdPrato());
        recuperado.setValor(entidade.getValor());
        return recuperado;
    }

    public Preco atribuirPreco(Preco preco, Restaurante restaurante, Prato prato) {
        Restaurante recuperadoRestaurante = restauranteRepository.findById(restaurante.getId()).orElse(null);
        Prato recuperadoPrato = pratoRepository.findById(prato.getId()).orElse(null);
        preco.setIdRestaurante(recuperadoRestaurante);
        preco.setIdPrato(recuperadoPrato);
        return repository.save(preco);
    }

    public List<Preco> findByIdPrato(Prato pratos) {
        List<Preco> precos = getRepository().findByIdPrato(pratos);
        return precos;
    }
}