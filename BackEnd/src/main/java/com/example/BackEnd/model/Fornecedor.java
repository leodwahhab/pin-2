package com.example.BackEnd.model;

import com.example.BackEnd.dtos.FornecedorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String email;

    public Fornecedor(FornecedorDTO fornecedorDTO) {
        this.email = fornecedorDTO.email();
        this.nome = fornecedorDTO.nome();
    }
}
