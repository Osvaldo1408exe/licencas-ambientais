package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Tipo;
import com.caj.ecolicencas.dao.TipoDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoService {
    private final TipoDAO tipoDAO;

    public TipoService(TipoDAO tipoDAO) {
        this.tipoDAO = tipoDAO;
    }

    public List<Tipo> findAllActiveTipo() {
        return tipoDAO.findAll();
    }
}
