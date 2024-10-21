package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.SituacaoLicenca;
import com.caj.ecolicencas.dao.SituacaoLicencaDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SituacaoLicencaService {
    private final SituacaoLicencaDAO situacaoLicencaDAO;

    public SituacaoLicencaService(SituacaoLicencaDAO situacaoLicencaDAO) {
        this.situacaoLicencaDAO = situacaoLicencaDAO;
    }

    public List<SituacaoLicenca> findAllActiveSituacaoLicencas(){
        return  situacaoLicencaDAO.findAll();
    }
}
