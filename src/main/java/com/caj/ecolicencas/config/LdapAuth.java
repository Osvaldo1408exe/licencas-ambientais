package com.caj.ecolicencas.config;

import com.caj.ecolicencas.model.entities.Usuario;
import io.github.cdimascio.dotenv.Dotenv;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class LdapAuth {


    public static Usuario auth(Usuario usuario){
        Dotenv dotenv = Dotenv.load();
        // Dados de autenticação
        String ldapServer = dotenv.get("LDAP_SERVER");
        String ldapPort = dotenv.get("LDAP_PORT");
        String domain = dotenv.get("DOMAIN");
        String username = usuario.getUsuario();
        String password = usuario.getSenha();

        // Formatar o nome do usuário com o domínio
        String ldapUser = domain + "\\" + username;

        // Configurar as propriedades de conexão LDAP
        Hashtable<String, String> environment = new Hashtable<>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, ldapServer + ":" + ldapPort);
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, ldapUser);
        environment.put(Context.SECURITY_CREDENTIALS, password);

        try {
            // Tenta se conectar e autenticar no servidor LDAP
            DirContext context = new InitialDirContext(environment);
            context.close();
            usuario.setAuth(true);
            return usuario;
        } catch (NamingException e) {
            System.out.println("Falha na autenticação: " + e.getMessage());
            usuario.setAuth(false);
            return usuario;
        }
    }
}
