package com.caj.ecolicencas.service;


import com.caj.ecolicencas.model.entities.ProcessoSei;
import com.caj.ecolicencas.dao.ProcessoSeiDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessoSeiService {
    private final ProcessoSeiDAO processoSeiDAO;

    public ProcessoSeiService(ProcessoSeiDAO processoSeiDAO){
        this.processoSeiDAO = processoSeiDAO;
    }

    public List<ProcessoSei> findAllActiveProcessos(){
        return processoSeiDAO.findAll();
    }
}
