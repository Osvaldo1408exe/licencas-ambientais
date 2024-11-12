package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.dto.LicencaResponseDTO;
import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.model.entities.Usuario;
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
        licencaService.atualizaTodosItens();//cada solicitação de get para as licenças é feito a verificação para atualiza-las

        List<Licenca> licencas = licencaService.findAllActiveLicenca();
        return ResponseEntity.ok(licencas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Licenca> getLicencaById(@PathVariable int id){
        Optional<Licenca> licenca = licencaService.findByLicencaById(id);
        return licenca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Licenca> adicionarLicenca(@RequestBody LicencaResponseDTO licencaResponseDTO){
        Licenca licenca = licencaResponseDTO.getLicenca();
        Usuario usuario = licencaResponseDTO.getUsuario();
        Licenca licencaNova = licencaService.insertLicencas(licenca, usuario);
        return ResponseEntity.ok(licencaNova);
    }

    @PutMapping("{id}")
    public ResponseEntity<Licenca> atualizarLicenca(@PathVariable int id, @RequestBody LicencaResponseDTO licencaResponseDTO){
        Licenca licencaAtualizada = licencaResponseDTO.getLicenca();
        Usuario usuario = licencaResponseDTO.getUsuario();
        Licenca licencaPut = licencaService.updateLicenca(id,licencaAtualizada, usuario);
        return ResponseEntity.ok(licencaPut);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarLicenca(@PathVariable int id){
        return ResponseEntity.ok(licencaService.deleteLicencas(id));

    }
}
