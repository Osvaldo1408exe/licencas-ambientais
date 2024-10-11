package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.SubUnidade;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SubUnidadeRepository {
    String sql = "SELECT * FROM sub_unidade WHERE ativo = 's'";

    public List<SubUnidade> findAll(){
        List<SubUnidade> sub_unidades = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                SubUnidade sub_unidade = new SubUnidade(rs.getInt("id_subunidade"), rs.getString("descricao"),rs.getString("ativo"));
                sub_unidades.add(sub_unidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sub_unidades;
    }
}
