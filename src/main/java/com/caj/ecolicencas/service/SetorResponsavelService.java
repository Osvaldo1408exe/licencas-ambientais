package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.SetorResponsavel;
import com.caj.ecolicencas.dao.SetorResponsavelDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorResponsavelService {
    private final SetorResponsavelDAO setorResponsavelDAO;

    public SetorResponsavelService(SetorResponsavelDAO setorResponsavelDAO) {
        this.setorResponsavelDAO = setorResponsavelDAO;
    }

    public List<SetorResponsavel> findAllActiveSetores(){
        return setorResponsavelDAO.findAll();
    }
}
