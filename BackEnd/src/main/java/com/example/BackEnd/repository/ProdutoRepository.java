package com.example.BackEnd.repository;

import com.example.BackEnd.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByFornecedorId(Long fornecedorId);
}
