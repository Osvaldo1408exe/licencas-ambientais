package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.model.entities.Area;
import com.caj.ecolicencas.service.AreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/campos")
public class CamposController {
    private final AreaService areaService;

    public CamposController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public List<Area> getAllAreas(){
        return areaService.getAllActiveAreas();
    }

}
