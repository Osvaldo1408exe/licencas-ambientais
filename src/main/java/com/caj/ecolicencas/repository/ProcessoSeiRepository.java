package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.ProcessoSei;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProcessoSeiRepository {
    String sql = "SELECT * FROM processo_sei WHERE ativo = 's'";

    public List<ProcessoSei> findAll(){
        List<ProcessoSei> processos = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                ProcessoSei processo_sei = new ProcessoSei(rs.getInt("id_processo_sei"), rs.getString("descricao"),rs.getString("ativo"));
                processos.add(processo_sei);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return processos;
    }
}
