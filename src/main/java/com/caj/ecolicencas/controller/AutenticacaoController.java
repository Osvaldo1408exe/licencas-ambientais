package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.dto.UsuarioResponseDTO;
import com.caj.ecolicencas.model.entities.Usuario;
import com.caj.ecolicencas.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class AutenticacaoController {
    private final AuthService authService;

    public AutenticacaoController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody Usuario usuario){
        usuario = authService.autenticacao(usuario);
        UsuarioResponseDTO usuarioResponse = new UsuarioResponseDTO(usuario.getUsuario(),usuario.getAuth());
        return ResponseEntity.ok().body(usuarioResponse);
    }
}
