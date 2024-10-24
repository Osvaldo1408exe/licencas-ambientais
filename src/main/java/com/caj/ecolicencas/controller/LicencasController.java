package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.service.LicencaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Licenca> getLicencaById(@PathVariable int id){
        Optional<Licenca> licenca = licencaService.findByLicencaById(id);
        return licenca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
