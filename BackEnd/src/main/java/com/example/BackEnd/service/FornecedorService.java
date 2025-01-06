package com.example.BackEnd.service;

import com.example.BackEnd.dtos.FornecedorDTO;
import com.example.BackEnd.model.Fornecedor;
import com.example.BackEnd.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor findById(Long id){
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        return fornecedor.orElse(null);
    }

    public void cadastrar(FornecedorDTO fornecedorDTO) {
        fornecedorRepository.save(new Fornecedor(fornecedorDTO));
    }

    public void avaliarFornecedor(int avaliacao, Long fornecedorId) {
        Fornecedor fornecedor = findById(fornecedorId);

        fornecedor.setAvaliacao(avaliacao);

        fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> getFornecedores() {
        List<FornecedorDTO> fornecedorDTOList = new ArrayList<>();
        List<Fornecedor> fornecedorList = fornecedorRepository.findAll();

//        fornecedorList.forEach(fornecedor -> fornecedorDTOList.add(
//                new FornecedorDTO(
//                        fornecedor.getNome(),
//                        fornecedor.getEmail(),
//                        fornecedor.getAvaliacao()
//                )
//        ));

        return fornecedorList;
    }
}
