package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Previsao;
import com.caj.ecolicencas.repository.PrevisaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrevisaoService {
    private final PrevisaoRepository previsaoRepository;

    public PrevisaoService(PrevisaoRepository previsaoRepository){
        this.previsaoRepository = previsaoRepository;
    }

    public List<Previsao> findAllActivePrevisoes(){
        return previsaoRepository.findAll();
    }
}
