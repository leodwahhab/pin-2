package com.example.BackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double preco;

    private LocalDate dataValidade;
    private LocalDate dataColeta;
    private String epocaProducao;

    @ManyToOne
    @JoinColumn(name = "fornecedorId", nullable = false)
    private Fornecedor fornecedor;
}
