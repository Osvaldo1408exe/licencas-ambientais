package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Unidade;
import com.caj.ecolicencas.dao.UnidadeDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {
    private final UnidadeDAO unidadeDAO;

    public UnidadeService(UnidadeDAO unidadeDAO) {
        this.unidadeDAO = unidadeDAO;
    }

    public List<Unidade> findAllActivUnidade() {
        return unidadeDAO.findAll();
    }
}
