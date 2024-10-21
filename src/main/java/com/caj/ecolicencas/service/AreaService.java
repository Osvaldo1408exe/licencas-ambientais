package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Area;
import com.caj.ecolicencas.dao.AreaDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaService {
    private final AreaDAO areaDAO;

    public AreaService(AreaDAO areaDAO) {
        this.areaDAO = areaDAO;
    }
    public List<Area> getAllActiveAreas(){
        return areaDAO.findAll();
    }
}
