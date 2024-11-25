package com.example.BackEnd.service;

import com.example.BackEnd.dtos.FornecedorDTO;
import com.example.BackEnd.dtos.ProdutoRequestDTO;
import com.example.BackEnd.dtos.ProdutoResponseDTO;
import com.example.BackEnd.model.Produto;
import com.example.BackEnd.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorService fornecedorService;

    public void cadastrarProduto(ProdutoRequestDTO produtoRequestDTO, Long fornecedorId) {
        produtoRepository.save(
                Produto.builder()
                        .nome(produtoRequestDTO.getNome())
                        .preco(produtoRequestDTO.getPreco())
                        .dataValidade(produtoRequestDTO.getDataValidade())
                        .dataColeta(produtoRequestDTO.getDataColeta())
                        .epocaProducao(produtoRequestDTO.getEpocaProducao())
                        .fornecedor(fornecedorService.findById(fornecedorId))
                        .build()
        );
    }

    public List<ProdutoResponseDTO> getProdutos() {
        return OrmToResponseDto(
                produtoRepository.findAll()
        );
    }

    public Produto getProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        return produto.orElse(null);
    }

    public List<ProdutoResponseDTO> getProdutosByForncedor(Long fornecedorId) {
        return OrmToResponseDto(
                produtoRepository.findByFornecedorId(fornecedorId)
        );
    }

    private List<ProdutoResponseDTO> OrmToResponseDto(List<Produto> produtoList) {
        List<ProdutoResponseDTO> produtoRequestDTOList = new ArrayList<>();

        produtoList.forEach(produto -> {
            produtoRequestDTOList.add(
                    new ProdutoResponseDTO(
                            produto.getNome(),
                            produto.getPreco(),
                            produto.getDataValidade(),
                            produto.getDataColeta(),
                            produto.getEpocaProducao(),
                            new FornecedorDTO(
                                    produto.getFornecedor().getNome(),
                                    produto.getFornecedor().getEmail(),
                                    produto.getFornecedor().getAvaliacao()
                            )
                    )
            );
        });

        return produtoRequestDTOList;
    }
}
