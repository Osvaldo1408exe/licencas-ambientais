package com.caj.ecolicencas.model.entities;

import com.caj.ecolicencas.model.enuns.TipoLogs;
import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue
    @Column(name = "id_log")
    private int id_log;
    @Column(name = "usuario", length = 30)
    private String usuario;
    @Column(name = "data_entrada")
    private LocalDateTime data_entrada;
    @Column(name = "tipo_log", length = 15)
    private int tipoLogs;

    public Logs() {
    }

    public Logs(String usuario, LocalDateTime data_entrada) {
        this.usuario = usuario;
        this.data_entrada = data_entrada;

    }

    public int getId_log() {
        return id_log;
    }

    public void setId_log(int id_log) {
        this.id_log = id_log;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(LocalDateTime data_entrada) {
        this.data_entrada = data_entrada;
    }

    public int getTipoLogs() {
        return tipoLogs;
    }

    public void setTipoLogs(int tipoLogs) {
        this.tipoLogs = tipoLogs;
    }
}
