package com.example.BackEnd.controller;

import com.example.BackEnd.dtos.FornecedorDTO;
import com.example.BackEnd.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity cadastrarFornecedor(@RequestBody FornecedorDTO fornecedorDTO) {
        fornecedorService.cadastrar(fornecedorDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity avaliarFornecedor(@RequestBody int avaliacao, @PathVariable Long id) {
        fornecedorService.avaliarFornecedor(avaliacao, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> getFornecedores() {
        return ResponseEntity.ok(
                fornecedorService.getFornecedores()
        );
    }
}
