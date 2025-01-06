package com.example.BackEnd.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter

public class PedidoRequestDTO {
    Long usuarioId;
    List<Long> produtoIds;
}
