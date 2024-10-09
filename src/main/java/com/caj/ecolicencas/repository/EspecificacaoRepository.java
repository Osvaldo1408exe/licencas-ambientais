package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.Especificacao;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EspecificacaoRepository {

    String sql = "SELECT * FROM especificacao WHERE ativo = 's'";

    public List<Especificacao> findAll(){
        List<Especificacao> especificacaos = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Especificacao especificacao = new Especificacao(rs.getInt("id_especificacao"),rs.getString("descricao"),rs.getString("ativo"));
                especificacaos.add(especificacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especificacaos;
    }
}
