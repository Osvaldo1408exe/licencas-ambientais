package com.caj.ecolicencas.dao;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.SituacaoProcesso;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SituacaoProcessoDAO {
    String sql = "SELECT * FROM situacao_processo WHERE ativo = 's'";

    public List<SituacaoProcesso> findAll(){
        List<SituacaoProcesso> situacaoProcessos = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                SituacaoProcesso situacao_processo = new SituacaoProcesso(rs.getInt("id_situacao_processo"), rs.getString("descricao"),rs.getString("ativo"));
                situacaoProcessos.add(situacao_processo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return situacaoProcessos;
    }
}
