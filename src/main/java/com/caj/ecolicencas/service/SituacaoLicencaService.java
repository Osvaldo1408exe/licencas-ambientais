package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.SituacaoLicenca;
import com.caj.ecolicencas.repository.SituacaoLicencaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SituacaoLicencaService {
    private final SituacaoLicencaRepository situacaoLicencaRepository;

    public SituacaoLicencaService(SituacaoLicencaRepository situacaoLicencaRepository) {
        this.situacaoLicencaRepository = situacaoLicencaRepository;
    }

    public List<SituacaoLicenca> findAllActiveSituacaoLicencas(){
        return  situacaoLicencaRepository.findAll();
    }
}
