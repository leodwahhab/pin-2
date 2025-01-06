package com.example.BackEnd.controller;

import com.example.BackEnd.dtos.PedidoRequestDTO;
import com.example.BackEnd.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @PostMapping("{fornecedorId}")
    public ResponseEntity<Object> realizarPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO, @PathVariable Long fornecedorId) {
        pedidoService.realizarPedido(pedidoRequestDTO, fornecedorId);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getPedidos() {
        return ResponseEntity.ok().body(pedidoService.getPedidos());
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity getPedidosByUsuario(@PathVariable Long usuarioId){
        return ResponseEntity.ok().body(pedidoService.getPedidosByUsuario(usuarioId));
    }
}
