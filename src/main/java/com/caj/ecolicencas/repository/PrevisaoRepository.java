package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.Previsao;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PrevisaoRepository {
    String sql = "SELECT * FROM previsao WHERE ativo = 's'";

    public List<Previsao> findAll(){
        List<Previsao> previsoes = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Previsao previsao = new Previsao(rs.getInt("id_previsao"), rs.getString("descricao"),rs.getString("ativo"));
                previsoes.add(previsao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return previsoes;
    }
}
