package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.repository.LicencaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicencaService {
    private final LicencaRepository licencaRepository;

    public LicencaService(LicencaRepository licencaRepository){
        this.licencaRepository = licencaRepository;
    }

    public List<Licenca> findAllActiveLicenca(){
        return licencaRepository.findAll();
    }
}
