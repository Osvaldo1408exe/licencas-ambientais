package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Previsao;
import com.caj.ecolicencas.dao.PrevisaoDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrevisaoService {
    private final PrevisaoDAO previsaoDAO;

    public PrevisaoService(PrevisaoDAO previsaoDAO){
        this.previsaoDAO = previsaoDAO;
    }

    public List<Previsao> findAllActivePrevisoes(){
        return previsaoDAO.findAll();
    }
}
