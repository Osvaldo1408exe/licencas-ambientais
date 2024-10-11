package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.service.LicencaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "licencas")
public class LicencasController {
    private final LicencaService licencaService;

    public LicencasController(LicencaService licencaService){
        this.licencaService = licencaService;
    }

    @GetMapping
    public ResponseEntity<List<Licenca>> getLicencas(){
        List<Licenca> licencas = licencaService.findAllActiveLicenca();
        return ResponseEntity.ok(licencas);
    }
}
