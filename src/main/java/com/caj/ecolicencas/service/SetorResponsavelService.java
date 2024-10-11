package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.SetorResponsavel;
import com.caj.ecolicencas.repository.SetorResponsavelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorResponsavelService {
    private final SetorResponsavelRepository setorResponsavelRepository;

    public SetorResponsavelService(SetorResponsavelRepository setorResponsavelRepository) {
        this.setorResponsavelRepository = setorResponsavelRepository;
    }

    public List<SetorResponsavel> findAllActiveSetores(){
        return setorResponsavelRepository.findAll();
    }
}
