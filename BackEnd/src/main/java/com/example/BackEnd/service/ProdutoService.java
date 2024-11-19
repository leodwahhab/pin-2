package com.example.BackEnd.service;

import com.example.BackEnd.dtos.FornecedorDTO;
import com.example.BackEnd.dtos.ProdutoDTO;
import com.example.BackEnd.model.Produto;
import com.example.BackEnd.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorService fornecedorService;

    public void cadastrarProduto(ProdutoDTO produtoDTO, Long fornecedorId) {
        produtoRepository.save(
                Produto.builder()
                        .nome(produtoDTO.nome())
                        .preco(produtoDTO.preco())
                        .dataValidade(produtoDTO.dataValidade())
                        .dataColeta(produtoDTO.dataColeta())
                        .epocaProducao(produtoDTO.epocaProducao())
                        .fornecedor(fornecedorService.findById(fornecedorId))
                        .build()
        );
    }

    public List<ProdutoDTO> getProdutos() {
        List<Produto> produtoList = produtoRepository.findAll();
        List<ProdutoDTO> produtoDTOList = new ArrayList<>();

        produtoList.forEach(produto -> {
            produtoDTOList.add(
              new ProdutoDTO(
                      produto.getNome(),
                      produto.getPreco(),
                      produto.getDataValidade(),
                      produto.getDataColeta(),
                      produto.getEpocaProducao(),
                      new FornecedorDTO(
                              produto.getFornecedor().getNome(),
                              produto.getFornecedor().getEmail()
                      )
              )
            );
        });

        return produtoDTOList;
    }

}
