package com.caj.ecolicencas.dto;

public class UsuarioResponseDTO {
    private String usuario;
    private Boolean autenticado;

    public UsuarioResponseDTO(String usuario, Boolean autenticado) {
        this.usuario = usuario;
        this.autenticado = autenticado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getAutenticacao() {
        return autenticado;
    }

    public void setAutenticacao(Boolean autenticado) {
        this.autenticado = autenticado;
    }
}
