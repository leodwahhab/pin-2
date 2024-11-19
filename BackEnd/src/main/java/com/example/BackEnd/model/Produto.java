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

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long id;

    private String nome;
    private double preco;
    private LocalDate dataValidade;
    private LocalDate dataColeta;
    private String epocaProducao;

    @ManyToOne
    @JoinColumn(name = "fornecedorId", nullable = false)
    private Fornecedor fornecedor;
}
