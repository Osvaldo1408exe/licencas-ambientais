package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Controle;
import com.caj.ecolicencas.repository.ControleRepository;

import java.util.List;

public class ControleService {
    private final ControleRepository controleRepository;

    public  ControleService (ControleRepository controleRepository) {
        this.controleRepository = controleRepository;
    }

    public List<Controle> getAllActiveControles(){ return controleRepository.findAll();}
}
