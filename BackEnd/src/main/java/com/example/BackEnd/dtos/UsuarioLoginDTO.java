package com.example.BackEnd.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class UsuarioLoginDTO {
    private String email;
    private String senha;
}
