package br.com.tiacademy.apidontstarve.controller;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tiacademy.apidontstarve.crud.CrudController;
import br.com.tiacademy.apidontstarve.domain.Restaurante;
import br.com.tiacademy.apidontstarve.service.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController extends CrudController<Restaurante, Long> {
    public RestauranteService getService(){
        return (RestauranteService) service;
    }
    
    @GetMapping("/entrega")
    public ResponseEntity<List<Restaurante>> consultaRestauranteEntrega(){
        List<Restaurante> restaurantesEntrega = getService().consultaRestauranteEntrega();
        return ResponseEntity.ok(restaurantesEntrega);
    }
}