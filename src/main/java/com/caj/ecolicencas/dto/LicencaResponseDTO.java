package com.caj.ecolicencas.dto;

import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.model.entities.Usuario;

public class LicencaResponseDTO {
    private Licenca licenca;
    private Usuario usuario;

    public LicencaResponseDTO(Licenca licenca, Usuario usuario) {
        this.licenca = licenca;
        this.usuario = usuario;
    }

    public Licenca getLicenca() {
        return licenca;
    }

    public void setLicenca(Licenca licenca) {
        this.licenca = licenca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
