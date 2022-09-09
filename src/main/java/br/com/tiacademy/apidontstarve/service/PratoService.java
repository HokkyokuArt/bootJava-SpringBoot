package br.com.tiacademy.apidontstarve.service;
import org.springframework.stereotype.Service;
import br.com.tiacademy.apidontstarve.crud.CrudService;
import br.com.tiacademy.apidontstarve.domain.Prato;
import br.com.tiacademy.apidontstarve.repository.PratoRepository;

@Service
public class PratoService extends CrudService<Prato, Long>{
    public PratoRepository getRepository(){
        return (PratoRepository) repository;
    } 

    @Override
    protected Prato editarEntidade(Prato recuperado, Prato entidade){
        recuperado.setNome(entidade.getNome());
        return recuperado;
    }

    public Prato consultaPeloNome(String nome){
        Prato recuperado = getRepository().consultaPeloNome(nome);
        return recuperado;
    }

}