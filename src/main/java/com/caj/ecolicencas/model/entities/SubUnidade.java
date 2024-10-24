package com.caj.ecolicencas.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_unidade")
public class SubUnidade {
    @Id
    @Column(name = "id_subunidade")
    private int Id;
    @Column(name = "descricao",nullable = true,length = 100)
    private String descricao;
    @Column(name = "ativo",nullable = false,length = 1)
    private String ativo;

    public SubUnidade() {
    }

    public SubUnidade(int id, String descricao, String ativo) {
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
