package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.model.entities.HistoricoObservacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistoricoObsRepository extends JpaRepository<HistoricoObservacoes, Integer> {

    Optional<HistoricoObservacoes> findBylicenca(int id);
}
