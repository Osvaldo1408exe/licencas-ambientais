package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.HistoricoObservacoes;
import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.model.entities.Usuario;
import com.caj.ecolicencas.repository.HistoricoObsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class HistoricoObsService {
    private final HistoricoObsRepository historicoObsRepository;

    public HistoricoObsService(HistoricoObsRepository historicoObsRepository) {
        this.historicoObsRepository = historicoObsRepository;
    }

    public List<HistoricoObservacoes> getHistorico(int id){
        List<HistoricoObservacoes> historicoObservacoes = historicoObsRepository.findAllWhereLicenca(id);
        return historicoObservacoes;
    }

    public void insertHistorico(Licenca licenca, Usuario usuario){
        HistoricoObservacoes historicoObs = new HistoricoObservacoes(licenca.getId(), usuario.getUsuario(), licenca.getObservacoes(), LocalDate.now());
        historicoObsRepository.save(historicoObs);

    }
}
