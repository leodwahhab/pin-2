package com.example.BackEnd.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class UsuarioDTO {
    private String nome;
    private int idade;
    private String cpf;
    private String email;
    private String senha;
}
