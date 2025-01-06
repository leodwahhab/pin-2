package com.example.BackEnd.service;

import com.example.BackEnd.dtos.PedidoRequestDTO;
import com.example.BackEnd.model.Pedido;
import com.example.BackEnd.model.Produto;
import com.example.BackEnd.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ProdutoService produtoService;

    public void realizarPedido(PedidoRequestDTO pedidoRequestDTO, Long fornecedorId) {
        List<Produto> produtoList = new ArrayList<>();

        pedidoRequestDTO.getProdutoIds().forEach(produtoId -> {
            produtoList.add(produtoService.getProduto(produtoId));
        });

        pedidoRepository.save(
                Pedido.builder()
                        .data(LocalDate.now())
                        .produto(produtoList)
                        .usuario(usuarioService.getUsuario(pedidoRequestDTO.getUsuarioId()))
                        .build()
        );
    }

    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> getPedidosByUsuario(Long usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }
}
