package com.caj.ecolicencas.dao;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.Unidade;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UnidadeDAO {
    String sql = "SELECT * FROM unidade WHERE ativo = 's'";

    public List<Unidade> findAll(){
        List<Unidade> unidades = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Unidade unidade = new Unidade(rs.getInt("id_unidade"), rs.getString("descricao"),rs.getString("ativo"));
                unidades.add(unidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unidades;
    }
}
