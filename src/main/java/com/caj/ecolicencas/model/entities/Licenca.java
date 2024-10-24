package com.caj.ecolicencas.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "licencas")
public class Licenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_licenca")
    private int id;

    // Relacionamentos com as outras tabelas
    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "id_unidade", nullable = false)
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "id_subunidade", nullable = false)
    private SubUnidade subUnidade;

    @Column(name = "data_requerimento",nullable = true)
    private Date dataRequerimento;

    @ManyToOne
    @JoinColumn(name = "id_controle", nullable = false)
    private Controle controle;

    @ManyToOne
    @JoinColumn(name = "id_orgao", nullable = false)
    private OrgaoEmissor orgao;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "id_especificacao", nullable = false)
    private Especificacao especificacao;

    @ManyToOne
    @JoinColumn(name = "id_previsao", nullable = false)
    private Previsao previsao;

    @ManyToOne
    @JoinColumn(name = "id_requerimento", nullable = false)
    private SimNao requerimento;

    @ManyToOne
    @JoinColumn(name = "id_emitida_nova_licenca", nullable = false)
    private SimNao emitidaNovaLicenca;

    @ManyToOne
    @JoinColumn(name = "id_situacao_processo", nullable = false)
    private SituacaoProcesso situacaoProcesso;

    @ManyToOne
    @JoinColumn(name = "id_atualizado_sa", nullable = false)
    private SimNao atualizadoSa;

    @ManyToOne
    @JoinColumn(name = "id_situacao_licenca", nullable = false)
    private SituacaoLicenca situacaoLicenca;

    @ManyToOne
    @JoinColumn(name = "id_setor_responsavel", nullable = false)
    private SetorResponsavel setorResponsavel;

    // Outros atributos diretos da tabela licencas
    @Column(name = "numero_licenca", nullable = false, length = 100)
    private String numLicenca;

    @Column(name = "fcei_sinfat")
    private int fceiSinfat;

    @Column(name = "num_processo_sinfat", length = 50)
    private String numProcessoSinfat;

    @Column(name = "sgpe", length = 100)
    private String sgpe;

    @Column(name = "processo_sei", length = 100)
    private String processoSei;

    @Column(name = "data_emissao")
    private Date dataEmissao;

    @Column(name = "data_vencimento", nullable = false)
    private Date dataVencimento;

    @Column(name = "data_protocolo_orgao")
    private Date dataProcotoloOrgao;

    @Column(name = "observacoes", length = 550)
    private String observacoes;

    @Column(name = "providenciar_doc")
    private Date providenciarDoc;

    @Column(name = "data_limite")
    private Date dataLimite;

    @Column(name = "tempo_tramitacao", nullable = false)
    private int tempoTramitacao;

    @Column(name = "dias_para_vencer")
    private int diasParaVencer;

    @Column(name = "ativo", length = 1, nullable = false)
    private String ativo;

    public Licenca() {

    }

    public Licenca(int id, Area area, Unidade unidade, SubUnidade subUnidade, Date dataRequerimento, Controle controle, OrgaoEmissor orgao, Tipo tipo, Especificacao especificacao, Previsao previsao, SimNao requerimento, SimNao emitidaNovaLicenca, SituacaoProcesso situacaoProcesso, SimNao atualizadoSa, SituacaoLicenca situacaoLicenca, SetorResponsavel setorResponsavel, String numLicenca, int fceiSinfat, String numProcessoSinfat, String sgpe, String processoSei, Date dataEmissao, Date dataVencimento, Date dataProcotoloOrgao, String observacoes, Date providenciarDoc, Date dataLimite, int tempoTramitacao, int diasParaVencer, String ativo) {
        this.id = id;
        this.area = area;
        this.unidade = unidade;
        this.subUnidade = subUnidade;
        this.dataRequerimento = dataRequerimento;
        this.controle = controle;
        this.orgao = orgao;
        this.tipo = tipo;
        this.especificacao = especificacao;
        this.previsao = previsao;
        this.requerimento = requerimento;
        this.emitidaNovaLicenca = emitidaNovaLicenca;
        this.situacaoProcesso = situacaoProcesso;
        this.atualizadoSa = atualizadoSa;
        this.situacaoLicenca = situacaoLicenca;
        this.setorResponsavel = setorResponsavel;
        this.numLicenca = numLicenca;
        this.fceiSinfat = fceiSinfat;
        this.numProcessoSinfat = numProcessoSinfat;
        this.sgpe = sgpe;
        this.processoSei = processoSei;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.dataProcotoloOrgao = dataProcotoloOrgao;
        this.observacoes = observacoes;
        this.providenciarDoc = providenciarDoc;
        this.dataLimite = dataLimite;
        this.tempoTramitacao = tempoTramitacao;
        this.diasParaVencer = diasParaVencer;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public SubUnidade getSubUnidade() {
        return subUnidade;
    }

    public void setSubUnidade(SubUnidade subUnidade) {
        this.subUnidade = subUnidade;
    }

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public Date getDataRequerimento() {
        return dataRequerimento;
    }

    public void setDataRequerimento(Date dataRequerimento) {
        this.dataRequerimento = dataRequerimento;
    }

    public OrgaoEmissor getOrgao() {
        return orgao;
    }

    public void setOrgao(OrgaoEmissor orgao) {
        this.orgao = orgao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Especificacao getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(Especificacao especificacao) {
        this.especificacao = especificacao;
    }

    public Previsao getPrevisao() {
        return previsao;
    }

    public void setPrevisao(Previsao previsao) {
        this.previsao = previsao;
    }

    public SimNao getRequerimento() {
        return requerimento;
    }

    public void setRequerimento(SimNao requerimento) {
        this.requerimento = requerimento;
    }

    public SimNao getEmitidaNovaLicenca() {
        return emitidaNovaLicenca;
    }

    public void setEmitidaNovaLicenca(SimNao emitidaNovaLicenca) {
        this.emitidaNovaLicenca = emitidaNovaLicenca;
    }

    public SituacaoProcesso getSituacaoProcesso() {
        return situacaoProcesso;
    }

    public void setSituacaoProcesso(SituacaoProcesso situacaoProcesso) {
        this.situacaoProcesso = situacaoProcesso;
    }

    public SimNao getAtualizadoSa() {
        return atualizadoSa;
    }

    public void setAtualizadoSa(SimNao atualizadoSa) {
        this.atualizadoSa = atualizadoSa;
    }

    public SituacaoLicenca getSituacaoLicenca() {
        return situacaoLicenca;
    }

    public void setSituacaoLicenca(SituacaoLicenca situacaoLicenca) {
        this.situacaoLicenca = situacaoLicenca;
    }

    public SetorResponsavel getSetorResponsavel() {
        return setorResponsavel;
    }

    public void setSetorResponsavel(SetorResponsavel setorResponsavel) {
        this.setorResponsavel = setorResponsavel;
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
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataProcotoloOrgao() {
        return dataProcotoloOrgao;
    }

    public void setDataProcotoloOrgao(Date dataProcotoloOrgao) {
        this.dataProcotoloOrgao = dataProcotoloOrgao;
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
