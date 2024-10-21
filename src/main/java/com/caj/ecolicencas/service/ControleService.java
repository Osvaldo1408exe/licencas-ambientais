package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Controle;
import com.caj.ecolicencas.dao.ControleDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ControleService {
    private final ControleDAO controleDAO;

    public  ControleService (ControleDAO controleDAO) {
        this.controleDAO = controleDAO;
    }

    public List<Controle> getAllActiveControles(){
        return controleDAO.findAll();
    }
}
