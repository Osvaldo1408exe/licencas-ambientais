package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.SimNao;
import com.caj.ecolicencas.dao.SimNaoDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SimNaoService {
    private final SimNaoDAO simNaoDAO;

    public SimNaoService(SimNaoDAO simNaoDAO) {
        this.simNaoDAO = simNaoDAO;
    }

    public List<SimNao> findAllActiveSimNaos(){
        return simNaoDAO.findAll();
    }
}
