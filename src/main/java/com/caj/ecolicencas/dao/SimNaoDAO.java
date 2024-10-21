package com.caj.ecolicencas.dao;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.SimNao;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SimNaoDAO {
    String sql = "SELECT * FROM sim_nao WHERE ativo = 's'";

    public List<SimNao> findAll(){
        List<SimNao> simnaos = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                SimNao processo_sei = new SimNao(rs.getInt("id_sim_nao"), rs.getString("descricao"),rs.getString("ativo"));
                simnaos.add(processo_sei);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return simnaos;
    }
}
