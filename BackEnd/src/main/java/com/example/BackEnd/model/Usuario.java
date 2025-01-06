package com.example.BackEnd.model;

import com.example.BackEnd.dtos.UsuarioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String senha;

    public Usuario(UsuarioDTO usuarioDTO) {
        this.cpf = usuarioDTO.getCpf();
        this.email = usuarioDTO.getEmail();
        this.nome = usuarioDTO.getNome();
        this.idade = usuarioDTO.getIdade();
        this.senha = usuarioDTO.getSenha();
    }
}
