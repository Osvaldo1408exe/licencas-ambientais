package com.caj.ecolicencas.service;

import com.caj.ecolicencas.dao.SubUnidadeDAO;
import com.caj.ecolicencas.model.entities.SubUnidade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubUnidadeService {
    private final SubUnidadeDAO subUnidadeDAO;

    public SubUnidadeService(SubUnidadeDAO subUnidadeDAO) {
        this.subUnidadeDAO = subUnidadeDAO;
    }

    public List<SubUnidade> findAllActiveSubUnidade(){
        return  subUnidadeDAO.fingAll();
    }
}
