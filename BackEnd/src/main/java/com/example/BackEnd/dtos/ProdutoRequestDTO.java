package com.example.BackEnd.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProdutoRequestDTO {
    private String nome;
    private Double preco;
    private LocalDate dataValidade;
    private LocalDate dataColeta;
    private String epocaProducao;
}
