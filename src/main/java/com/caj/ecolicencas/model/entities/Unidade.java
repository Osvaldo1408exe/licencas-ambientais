package com.caj.ecolicencas.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidade")
public class Unidade {
    @Id
    @Column(name = "id_unidade")
    private int Id;
    @Column(name = "descricao",nullable = false,length = 100)
    private String descricao;
    @Column(name = "ativo",nullable = false,length = 1)
    private String ativo;

    public Unidade() {
    }

    public Unidade(int id, String descricao, String ativo) {
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
