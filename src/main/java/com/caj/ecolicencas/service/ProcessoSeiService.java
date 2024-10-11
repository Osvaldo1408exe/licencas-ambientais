package com.caj.ecolicencas.service;


import com.caj.ecolicencas.model.entities.ProcessoSei;
import com.caj.ecolicencas.repository.ProcessoSeiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessoSeiService {
    private final ProcessoSeiRepository processoSeiRepository;

    public ProcessoSeiService(ProcessoSeiRepository processoSeiRepository){
        this.processoSeiRepository = processoSeiRepository;
    }

    public List<ProcessoSei> findAllActiveProcessos(){
        return processoSeiRepository.findAll();
    }
}
