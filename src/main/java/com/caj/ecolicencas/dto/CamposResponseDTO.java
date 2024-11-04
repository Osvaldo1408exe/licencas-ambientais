package com.caj.ecolicencas.dto;


import com.caj.ecolicencas.model.entities.*;

import java.util.List;
public class CamposResponseDTO {
    private final List<Area> areas;
    private final List<Controle> controles;
    private final List<Especificacao> especificacaos;
    private final List<OrgaoEmissor> orgaoEmissors;
    private final List<Previsao> previsoes;
    private final List<SetorResponsavel> setores;
    private final List<SimNao> simnaos;
    private final List<SituacaoLicenca> situacoesLicencas;
    private final List<SituacaoProcesso> situcoesProcessos;
    private final List<SubUnidade> subUnidades;
    private final List<Tipo> tipos;
    private final List<Unidade> unidades;

    public CamposResponseDTO(List<Area> areas, List<Controle> controles, List<Especificacao> especificacaos, List<OrgaoEmissor> orgaoEmissors, List<Previsao> previsoes, List<SetorResponsavel> setores, List<SimNao> simnaos, List<SituacaoLicenca> situacoesLicencas, List<SituacaoProcesso> situcoesProcessos, List<SubUnidade> subUnidades, List<Tipo> tipos, List<Unidade> unidades) {
        this.areas = areas;
        this.controles = controles;
        this.especificacaos = especificacaos;
        this.orgaoEmissors = orgaoEmissors;
        this.previsoes = previsoes;
        this.setores = setores;
        this.simnaos = simnaos;
        this.situacoesLicencas = situacoesLicencas;
        this.situcoesProcessos = situcoesProcessos;
        this.subUnidades = subUnidades;
        this.tipos = tipos;
        this.unidades = unidades;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public List<Controle> getControles() {
        return controles;
    }

    public List<Especificacao> getEspecificacaos() {
        return especificacaos;
    }

    public List<OrgaoEmissor> getOrgaoEmissors() {
        return orgaoEmissors;
    }

    public List<Previsao> getPrevisoes(){
        return previsoes;
    }

    public List<SetorResponsavel> getSetores() {
        return setores;
    }

    public List<SimNao> getSimnaos() {
        return simnaos;
    }

    public List<SituacaoLicenca> getSituacoesLicencas() {
        return situacoesLicencas;
    }

    public List<SituacaoProcesso> getSitucoesProcessos() {
        return situcoesProcessos;
    }

    public List<SubUnidade> getSubUnidades() {
        return subUnidades;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }
}
