package com.example.BackEnd.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class ProdutoResponseDTO extends ProdutoRequestDTO {
    private FornecedorDTO fornecedorDTO;

    public ProdutoResponseDTO(String nome, Double preco, LocalDate dataValidade, LocalDate dataColeta, String epocaProducao, FornecedorDTO fornecedorDTO) {
        super(nome, preco, dataValidade, dataColeta, epocaProducao);
        this.fornecedorDTO = fornecedorDTO;
    }
}
