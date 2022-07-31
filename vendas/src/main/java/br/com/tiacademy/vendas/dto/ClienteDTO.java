package br.com.tiacademy.vendas.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO implements Serializable{
    private Long id;
    private String nome;

}