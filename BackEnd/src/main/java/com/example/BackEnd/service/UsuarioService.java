package com.example.BackEnd.service;

import com.example.BackEnd.dtos.UsuarioDTO;
import com.example.BackEnd.dtos.UsuarioLoginDTO;
import com.example.BackEnd.model.Usuario;
import com.example.BackEnd.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public void cadastrarUsuario(UsuarioDTO usuarioDTO) {
        usuarioRepository.save(new Usuario(usuarioDTO));
    }

    public List<Usuario> getUsuarios() {
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();
        List<Usuario> usuarioList = usuarioRepository.findAll();

//        usuarioList.forEach(usuario -> {
//            usuarioDTOList.add(
//                    new UsuarioDTO(
//                            usuario.getNome(),
//                            usuario.getIdade(),
//                            usuario.getCpf(),
//                            usuario.getEmail(),
//                            usuario.getSenha(),
//                            usuario.getRole()
//                    )
//            );
//        });

        return usuarioList;
    }

    public Usuario getUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return usuario.orElse(null);
    }

    public Long logar(UsuarioLoginDTO usuarioLoginDTO) throws Exception {
        Usuario usuario = usuarioRepository.findByEmail(usuarioLoginDTO.getEmail());

        if(usuario == null || !usuario.getSenha().equals(usuarioLoginDTO.getSenha()))
            throw new Exception("dados invalidos");
        return usuario.getId();
    }
}
