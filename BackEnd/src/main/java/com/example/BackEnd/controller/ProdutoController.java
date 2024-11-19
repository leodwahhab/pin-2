package com.example.BackEnd.controller;

import com.example.BackEnd.repository.ProdutoRepository;
import com.example.BackEnd.dtos.ProdutoDTO;
import com.example.BackEnd.model.Produto;
import com.example.BackEnd.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;


    @PostMapping("/{fornecedorId}")
    public ResponseEntity cadastrarProduto(@RequestBody ProdutoDTO produtoDTO, @PathVariable Long fornecedorId) {
        produtoService.cadastrarProduto(produtoDTO, fornecedorId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity getProdutos() {
        return ResponseEntity.ok().body(produtoService.getProdutos());
    }
}
