package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.model.entities.AuthResponse;
import com.caj.ecolicencas.model.entities.Usuario;
import com.caj.ecolicencas.service.AuthService;
import com.caj.ecolicencas.security.JwtService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> login(@RequestBody Usuario usuario){
        usuario = authService.autenticacao(usuario);
        if (usuario.getAuth().equals(true)){
            String token = JwtService.generateToken(usuario.getUsuario());
            return ResponseEntity.ok(new AuthResponse(token));
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
