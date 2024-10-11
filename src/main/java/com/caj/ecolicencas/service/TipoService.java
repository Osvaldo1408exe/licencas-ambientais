package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Tipo;
import com.caj.ecolicencas.repository.TipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoService {
    private final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    public List<Tipo> findAllActiveTipo() {
        return tipoRepository.findAll();
    }
}
