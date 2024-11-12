package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.model.entities.HistoricoObservacoes;
import com.caj.ecolicencas.service.HistoricoObsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historico")
public class HistoricoObsController {
    private final HistoricoObsService historicoObsService;

    public HistoricoObsController(HistoricoObsService historicoObsService){
        this.historicoObsService = historicoObsService;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<HistoricoObservacoes>> getHistorico(@PathVariable int id){
        List<HistoricoObservacoes> historico = historicoObsService.getHistorico(id);

        return ResponseEntity.ok().body(historico);

    }
}
