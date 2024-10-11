package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.SubUnidade;
import com.caj.ecolicencas.repository.SubUnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubUnidadeService {
    private final SubUnidadeRepository subUnidadeRepository;

    public SubUnidadeService(SubUnidadeRepository subUnidadeRepository) {
        this.subUnidadeRepository = subUnidadeRepository;
    }

    public List<SubUnidade> findAllActiveSubUnidade(){
        return  subUnidadeRepository.findAll();
    }
}
