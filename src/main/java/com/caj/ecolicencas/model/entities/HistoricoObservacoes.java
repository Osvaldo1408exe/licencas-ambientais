package com.caj.ecolicencas.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historico_obs")
public class HistoricoObservacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historico_obs" )
    private int id_historico;

    @Column(name = "id_licenca")
    private int licenca;

    @Column(name = "usuario", length = 50)
    private String usuario;

    @Column(name = "observacao", length = 550)
    private String observacao;

    @Column(name = "atualizado_em")
    private LocalDate atualizadoEm;

    public HistoricoObservacoes() {
    }

    public HistoricoObservacoes(int licenca, String usuario, String observacao, LocalDate atualizadoEm) {
        this.licenca = licenca;
        this.usuario = usuario;
        this.observacao = observacao;
        this.atualizadoEm = atualizadoEm;
    }

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public int getLicenca() {
        return licenca;
    }

    public void setLicenca(int licenca) {
        this.licenca = licenca;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getAtualizado_em() {
        return atualizadoEm;
    }

    public void setAtualizado_em(LocalDate atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
