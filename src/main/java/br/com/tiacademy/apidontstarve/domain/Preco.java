package br.com.tiacademy.apidontstarve.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import br.com.tiacademy.apidontstarve.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Preco implements CrudDomain<Long>, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_restaurante", referencedColumnName = "id", nullable = false)
    private Restaurante idRestaurante;
    @ManyToOne
    @JoinColumn(name = "id_prato", referencedColumnName = "id", nullable = false)
    private Prato idPrato;
    private BigDecimal valor;
}