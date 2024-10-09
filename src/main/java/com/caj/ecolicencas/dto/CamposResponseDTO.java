package com.caj.ecolicencas.dto;


import com.caj.ecolicencas.model.entities.*;

import java.util.List;

public class CamposResponseDTO {
    private final List<Area> areas;
    private final List<Controle> controles;
    private final List<Especificacao> especificacaos;
    private final List<OrgaoEmissor> orgaoEmissors;
    private final List<Previsao> previsoes;
    private final List<ProcessoSei> processosSei;
    private final List<SetorResponsavel> setores;


    public CamposResponseDTO(List<Area> areas, List<Controle> controles, List<Especificacao> especificacaos, List<OrgaoEmissor> orgaoEmissors, List<Previsao> previsoes, List<ProcessoSei> processosSei, List<SetorResponsavel> setores){
        this.areas = areas;
        this.controles = controles;
        this.especificacaos = especificacaos;
        this.orgaoEmissors = orgaoEmissors;
        this.previsoes = previsoes;
        this.processosSei = processosSei;
        this.setores = setores;
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

    public List<ProcessoSei> getProcessosSei() {
        return processosSei;
    }

    public List<SetorResponsavel> getSetores() {
        return setores;
    }
}
