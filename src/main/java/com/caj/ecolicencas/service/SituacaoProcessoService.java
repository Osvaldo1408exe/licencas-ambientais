package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.SituacaoProcesso;
import com.caj.ecolicencas.dao.SituacaoProcessoDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituacaoProcessoService {
    private final SituacaoProcessoDAO situacaoProcessoDAO;

    public SituacaoProcessoService(SituacaoProcessoDAO situacaoProcessoDAO) {
        this.situacaoProcessoDAO = situacaoProcessoDAO;
    }

    public List<SituacaoProcesso> findAllActivSituacaoProcesso(){
        return  situacaoProcessoDAO.findAll();
    }
}
