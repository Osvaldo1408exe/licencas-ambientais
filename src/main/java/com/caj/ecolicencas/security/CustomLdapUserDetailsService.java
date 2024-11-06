package com.caj.ecolicencas.security;

import com.caj.ecolicencas.model.entities.Usuario;
import com.caj.ecolicencas.config.LdapAuth;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomLdapUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Criar um usuário com o nome de usuário e senha
        Usuario usuario = new Usuario();
        usuario.setUsuario(username);  // Setar o nome de usuário recebido na autenticação
        usuario.setSenha("senha");  // A senha pode ser passada de algum lugar (como no JWT)

        // Tentar autenticar via LDAP
        usuario = LdapAuth.auth(usuario);

        if (usuario.getAuth()) {
            // Caso o usuário tenha sido autenticado, retornar como um UserDetails
            return User.builder()
                    .username(usuario.getUsuario())
                    .password(usuario.getSenha())  // Use a senha original ou outra política
                    .roles("USER")  // Aqui você pode configurar os roles conforme necessário
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado ou senha inválida");
        }
    }
}
