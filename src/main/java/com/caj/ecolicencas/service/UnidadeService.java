package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Unidade;
import com.caj.ecolicencas.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {
    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public List<Unidade> findAllActivUnidade() {
        return unidadeRepository.findAll();
    }
}
