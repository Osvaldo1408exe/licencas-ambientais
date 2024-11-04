package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.model.entities.SituacaoLicenca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoLicencaRepository extends JpaRepository<SituacaoLicenca,Integer> {

    SituacaoLicenca findByDescricao(String descricao);
}
