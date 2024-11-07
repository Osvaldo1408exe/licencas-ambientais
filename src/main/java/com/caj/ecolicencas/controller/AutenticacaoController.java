package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.model.entities.Usuario;
import com.caj.ecolicencas.security.JwtUtils;
import com.caj.ecolicencas.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")

public class AutenticacaoController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtils jwtUtils; // Classe responsável por gerar o token JWT

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody Usuario usuario) {
        authService.autenticacao(usuario);
        // Usando o AuthService para fazer a autenticação
        if (usuario.getAuth()) {
            // Gera o token JWT
            String token = jwtUtils.generate(usuario.getUsuario());

            // Crie uma resposta contendo o token e os dados do usuário
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", usuario.getUsuario()); // Método para obter os detalhes do usuário

            return ResponseEntity.ok(response);
        } else {
            // Retorne uma resposta de erro se a autenticação falhar
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}
