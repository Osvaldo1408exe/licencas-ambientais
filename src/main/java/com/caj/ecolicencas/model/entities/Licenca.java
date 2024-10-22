package com.caj.ecolicencas.model.entities;

import java.util.Date;

public class Licenca {
    private int id;
    private String area;
    private String unidade;
    private String subUnidade;
    private Date dataRequerimento;
    private String controle;
    private String orgao;
    private String tipo;
    private String especificacao;
    private String numLicenca;
    private int fceiSinfat;
    private String numProcessoSinfat;
    private String sgpe;
    private String processoSei;
    private Date dataEmissao;
    private Date DataVencimento;
    private String previsao;
    private String requerimento;
    private Date dataProcotoloOrgao;
    private String emitidaNovaLicenca;
    private String situacaoProcesso;
    private String atualizadoSa;
    private String observacoes;
    private Date providenciarDoc;
    private Date dataLimite;
    private int tempoTramitacao;
    private String situacaoLicenca;
    private String setorResponsavel;
    private int diasParaVencer;
    private String ativo;

    public Licenca(int id, String area, String unidade, String subUnidade, Date dataRequerimento, String controle, String orgao, String tipo, String especificacao, String numLicenca, int fceiSinfat, String numProcessoSinfat, String sgpe, String processoSei, Date dataEmissao, Date dataVencimento, String previsao, String requerimento, Date dataProcotoloOrgao, String emitidaNovaLicenca, String situacaoProcesso, String atualizadoSa, String observacoes, Date providenciarDoc, Date dataLimite, int tempoTramitacao, String situacaoLicenca, String setorResponsavel, int diasParaVencer, String ativo) {
        this.id = id;
        this.area = area;
        this.unidade = unidade;
        this.subUnidade = subUnidade;
        this.dataRequerimento = dataRequerimento;
        this.controle = controle;
        this.orgao = orgao;
        this.tipo = tipo;
        this.especificacao = especificacao;
        this.numLicenca = numLicenca;
        this.fceiSinfat = fceiSinfat;
        this.numProcessoSinfat = numProcessoSinfat;
        this.sgpe = sgpe;
        this.processoSei = processoSei;
        this.dataEmissao = dataEmissao;
        DataVencimento = dataVencimento;
        this.previsao = previsao;
        this.requerimento = requerimento;
        this.dataProcotoloOrgao = dataProcotoloOrgao;
        this.emitidaNovaLicenca = emitidaNovaLicenca;
        this.situacaoProcesso = situacaoProcesso;
        this.atualizadoSa = atualizadoSa;
        this.observacoes = observacoes;
        this.providenciarDoc = providenciarDoc;
        this.dataLimite = dataLimite;
        this.tempoTramitacao = tempoTramitacao;
        this.situacaoLicenca = situacaoLicenca;
        this.setorResponsavel = setorResponsavel;
        this.diasParaVencer = diasParaVencer;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getSubUnidade() {
        return subUnidade;
    }

    public void setSubUnidade(String subUnidade) {
        this.subUnidade = subUnidade;
    }

    public Date getDataRequerimento() {
        return dataRequerimento;
    }

    public void setDataRequerimento(Date dataRequerimento) {
        this.dataRequerimento = dataRequerimento;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getNumLicenca() {
        return numLicenca;
    }

    public void setNumLicenca(String numLicenca) {
        this.numLicenca = numLicenca;
    }

    public int getFceiSinfat() {
        return fceiSinfat;
    }

    public void setFceiSinfat(int fceiSinfat) {
        this.fceiSinfat = fceiSinfat;
    }

    public String getNumProcessoSinfat() {
        return numProcessoSinfat;
    }

    public void setNumProcessoSinfat(String numProcessoSinfat) {
        this.numProcessoSinfat = numProcessoSinfat;
    }

    public String getSgpe() {
        return sgpe;
    }

    public void setSgpe(String sgpe) {
        this.sgpe = sgpe;
    }

    public String getProcessoSei() {
        return processoSei;
    }

    public void setProcessoSei(String processoSei) {
        this.processoSei = processoSei;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVencimento() {
        return DataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        DataVencimento = dataVencimento;
    }

    public String getPrevisao() {
        return previsao;
    }

    public void setPrevisao(String previsao) {
        this.previsao = previsao;
    }

    public String getRequerimento() {
        return requerimento;
    }

    public void setRequerimento(String requerimento) {
        this.requerimento = requerimento;
    }

    public Date getDataProcotoloOrgao() {
        return dataProcotoloOrgao;
    }

    public void setDataProcotoloOrgao(Date dataProcotoloOrgao) {
        this.dataProcotoloOrgao = dataProcotoloOrgao;
    }

    public String getEmitidaNovaLicenca() {
        return emitidaNovaLicenca;
    }

    public void setEmitidaNovaLicenca(String emitidaNovaLicenca) {
        this.emitidaNovaLicenca = emitidaNovaLicenca;
    }

    public String getSituacaoProcesso() {
        return situacaoProcesso;
    }

    public void setSituacaoProcesso(String situacaoProcesso) {
        this.situacaoProcesso = situacaoProcesso;
    }

    public String getAtualizadoSa() {
        return atualizadoSa;
    }

    public void setAtualizadoSa(String atualizadoSa) {
        this.atualizadoSa = atualizadoSa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getProvidenciarDoc() {
        return providenciarDoc;
    }

    public void setProvidenciarDoc(Date providenciarDoc) {
        this.providenciarDoc = providenciarDoc;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public int getTempoTramitacao() {
        return tempoTramitacao;
    }

    public void setTempoTramitacao(int tempoTramitacao) {
        this.tempoTramitacao = tempoTramitacao;
    }

    public String getSituacaoLicenca() {
        return situacaoLicenca;
    }

    public void setSituacaoLicenca(String situacaoLicenca) {
        this.situacaoLicenca = situacaoLicenca;
    }

    public String getSetorResponsavel() {
        return setorResponsavel;
    }

    public void setSetorResponsavel(String setorResponsavel) {
        this.setorResponsavel = setorResponsavel;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }


}
