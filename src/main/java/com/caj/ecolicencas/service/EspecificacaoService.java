package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Especificacao;
import com.caj.ecolicencas.dao.EspecificacaoDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EspecificacaoService {
    private final EspecificacaoDAO especificacaoDAO;

    public EspecificacaoService(EspecificacaoDAO especificacaoDAO){
        this.especificacaoDAO = especificacaoDAO;
    }

    public List<Especificacao> findAllActiveEspecificacoes(){
        return  especificacaoDAO.findAll();
    }
}
