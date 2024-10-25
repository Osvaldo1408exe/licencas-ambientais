package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.SimNao;
import com.caj.ecolicencas.repository.SimNaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SimNaoService {
    private final SimNaoRepository simNaoRepository;

    public SimNaoService(SimNaoRepository simNaoRepository) {
        this.simNaoRepository = simNaoRepository;
    }

    public List<SimNao> findAllActiveSimNaos(){
        return simNaoRepository.findAll();
    }
}
