package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Area;
import com.caj.ecolicencas.repository.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaService {
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
    public List<Area> getAllActiveAreas(){
        return areaRepository.findAll();
    }
}
