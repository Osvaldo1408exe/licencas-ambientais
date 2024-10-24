package com.caj.ecolicencas.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "controle")
public class Controle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_controle")
    private int Id;
    @Column(name = "descricao", nullable = false, length = 20)
    private String descricao;
    @Column(name = "ativo", nullable = false, length = 1)
    private String ativo;

    public Controle() {
    }

    public Controle(int id, String descricao, String ativo) {
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
