package br.com.tiacademy.apidontstarve.service;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.tiacademy.apidontstarve.crud.CrudService;
import br.com.tiacademy.apidontstarve.domain.Restaurante;
import br.com.tiacademy.apidontstarve.repository.RestauranteRepository;

@Service
public class RestauranteService extends CrudService<Restaurante, Long> {
    public RestauranteRepository getRepository() {
        return (RestauranteRepository) repository;
    }

    @Override
    protected Restaurante editarEntidade(Restaurante recuperado, Restaurante entidade) {
        recuperado.setNome(entidade.getNome());
        recuperado.setCozinha(entidade.getCozinha());
        recuperado.setEndereco(entidade.getEndereco());
        recuperado.setEntrega(entidade.getEntrega());
        return recuperado;
    }

    public List<Restaurante> consultaRestauranteEntrega() {
        var restaurantes = getRepository().consultaRestauranteEntrega();
        return restaurantes;
    }
}