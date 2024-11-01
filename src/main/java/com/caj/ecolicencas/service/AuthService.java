package com.caj.ecolicencas.service;

import com.caj.ecolicencas.config.LdapAuth;
import com.caj.ecolicencas.model.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public Usuario autenticacao(Usuario usuario){

        LdapAuth.auth(usuario);
        return usuario;
    }
}
