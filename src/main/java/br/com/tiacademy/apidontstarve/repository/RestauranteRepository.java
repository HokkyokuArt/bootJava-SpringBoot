package br.com.tiacademy.apidontstarve.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.tiacademy.apidontstarve.crud.CrudRepository;
import br.com.tiacademy.apidontstarve.domain.Restaurante;

@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Long>{
    @Query(value = "select * from restaurante r where r.entrega = true", nativeQuery = true)
    List<Restaurante> consultaRestauranteEntrega();
}