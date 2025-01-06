package com.example.BackEnd.dtos;

import com.example.BackEnd.model.Usuario;
import com.example.BackEnd.model.Produto;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter

public class PedidoResponseDTO {
    private LocalDate data;
    private List<Produto> produto;
    private Usuario usuario;
}
