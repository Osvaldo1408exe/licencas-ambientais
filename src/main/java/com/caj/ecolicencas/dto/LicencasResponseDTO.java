package com.caj.ecolicencas.dto;

import com.caj.ecolicencas.model.entities.Licenca;

public class LicencasResponseDTO {

        private int id;
        private String descricaoArea;
        private String descricaoUnidade;
        private String descricaoSubUnidade;
        private String descricaoControle;
        private String descricaoOrgao;
        private String descricaoTipo;
        private String descricaoEspecificacao;
        private String descricaoPrevisao;
        private String descricaoSituacaoProcesso;
        private String descricaoSituacaoLicenca;
        private String descricaoSetorResponsavel;
        private String numLicenca;
        private String ativo;

        // Construtor que recebe a entidade Licenca e popula o DTO
        public LicencasResponseDTO(Licenca licenca) {
            this.id = licenca.getId();
            this.descricaoArea = licenca.getArea().getDescricao();
            this.descricaoUnidade = licenca.getUnidade().getDescricao();
            this.descricaoSubUnidade = licenca.getSubUnidade().getDescricao();
            this.descricaoControle = licenca.getControle().getDescricao();
            this.descricaoOrgao = licenca.getOrgao().getDescricao();
            this.descricaoTipo = licenca.getTipo().getDescricao();
            this.descricaoEspecificacao = licenca.getEspecificacao().getDescricao();
            this.descricaoPrevisao = licenca.getPrevisao().getDescricao();
            this.descricaoSituacaoProcesso = licenca.getSituacaoProcesso().getDescricao();
            this.descricaoSituacaoLicenca = licenca.getSituacaoLicenca().getDescricao();
            this.descricaoSetorResponsavel = licenca.getSetorResponsavel().getDescricao();
            this.numLicenca = licenca.getNumLicenca();
            this.ativo = licenca.getAtivo();
        }


}
