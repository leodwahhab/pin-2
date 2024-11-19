package com.example.BackEnd.dtos;

import java.time.LocalDate;

public record ProdutoDTO(String nome, double preco, LocalDate dataValidade, LocalDate dataColeta, String epocaProducao, FornecedorDTO fornecedorDTO) {
}
