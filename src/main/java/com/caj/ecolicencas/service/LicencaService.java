package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.dao.LicencaDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicencaService {
    private final LicencaDAO licencaDAO;

    public LicencaService(LicencaDAO licencaDAO){
        this.licencaDAO = licencaDAO;
    }

    public List<Licenca> findAllActiveLicenca(){
        return licencaDAO.findAll();
    }
}
