package com.caj.ecolicencas.model.enuns;

public enum TipoLogs {
    ENTRADA(1),
    TENTATIVA(2),
    SAIDA(3);

    private final int codigo;

    TipoLogs(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
