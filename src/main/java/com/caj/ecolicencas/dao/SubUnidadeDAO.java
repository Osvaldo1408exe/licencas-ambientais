package com.caj.ecolicencas.dao;

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
public class SubUnidadeDAO {
    String sql = "SELECT * FROM sub_unidade WHERE ativo = 's'";

    public List<SubUnidade> fingAll(){
        List<SubUnidade> subUnidade = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                SubUnidade sub_Unidade = new SubUnidade(rs.getInt("id_subunidade"),rs.getString("descricao"),rs.getString("ativo"));
                subUnidade.add(sub_Unidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subUnidade;
    }
}
