package com.example.BackEnd.repository;

import com.example.BackEnd.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value =
    "SELECT * " +
    "FROM " +
    "   usuario " +
    "WHERE " +
    "email = :email ", nativeQuery = true)
    Usuario findByEmail(@Param("email") final String email);
}
