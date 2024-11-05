package com.caj.ecolicencas.service;

import com.caj.ecolicencas.config.LdapAuth;
import com.caj.ecolicencas.model.entities.Logs;
import com.caj.ecolicencas.model.entities.Usuario;
import com.caj.ecolicencas.model.enuns.TipoLogs;
import com.caj.ecolicencas.repository.LogsRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AuthService {

    private final LogsRepository logsRepository;

    public AuthService(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    public Usuario autenticacao(Usuario usuario){


        //faz autenticação do usuario via servidor LDAP
        LdapAuth.auth(usuario);

        //log de usuarios
        logUsuario(usuario);

        return usuario;
    }

    private void logUsuario(Usuario usuario){
        LocalDateTime entrada = LocalDateTime.now();
        Logs log = new Logs(usuario.getUsuario(),entrada);

        if (usuario.getAuth().equals(true)){
            log.setTipoLogs(TipoLogs.ENTRADA.getCodigo());
        }else{
            log.setTipoLogs(TipoLogs.TENTATIVA.getCodigo());
        }
        logsRepository.save(log);
    }
}
