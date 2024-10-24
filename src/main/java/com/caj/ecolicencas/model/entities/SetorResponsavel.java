package com.caj.ecolicencas.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "setor_responsavel")
public class SetorResponsavel {
    @Id
    @Column(name = "id_setor_responsavel")
    private int Id;
    @Column(name = "descricao",nullable = false,length = 50)
    private String descricao;
    @Column(name = "ativo",nullable = false,length = 1)
    private String ativo;

    public SetorResponsavel() {
    }

    public SetorResponsavel(int id, String descricao, String ativo) {
        Id = id;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }


}
