package com.example.BackEnd.controller;

import com.example.BackEnd.repository.FornecedorRepository;
import com.example.BackEnd.dtos.FornecedorDTO;
import com.example.BackEnd.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    FornecedorRepository fornecedorRepository;

    @PostMapping
    public ResponseEntity cadastrarFornecedor(@RequestBody FornecedorDTO fornecedorDTO) {
            return ResponseEntity.ok(
                    fornecedorRepository.save(new Fornecedor(fornecedorDTO))
            );
    }
}
