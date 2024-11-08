package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.model.entities.HistoricoObservacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HistoricoObsRepository extends JpaRepository<HistoricoObservacoes, Integer> {

    @Query("SELECT h FROM HistoricoObservacoes h WHERE h.licenca = :id ORDER BY id_historico DESC")
    List<HistoricoObservacoes> findAllWhereLicenca(@Param("id") int id);
}
