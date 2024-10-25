package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Especificacao;
import com.caj.ecolicencas.repository.EspecificacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EspecificacaoService {
    private final EspecificacaoRepository especificacaoRepository;

    public EspecificacaoService(EspecificacaoRepository especificacaoRepository){
        this.especificacaoRepository = especificacaoRepository;
    }

    public List<Especificacao> findAllActiveEspecificacoes(){
        return  especificacaoRepository.findAll();
    }
}
