package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.SituacaoProcesso;
import com.caj.ecolicencas.repository.SituacaoProcessoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituacaoProcessoService {
    private final SituacaoProcessoRepository situacaoProcessoRepository;

    public SituacaoProcessoService(SituacaoProcessoRepository situacaoProcessoRepository) {
        this.situacaoProcessoRepository = situacaoProcessoRepository;
    }

    public List<SituacaoProcesso> findAllActivSituacaoProcesso(){
        return  situacaoProcessoRepository.findAll();
    }
}
