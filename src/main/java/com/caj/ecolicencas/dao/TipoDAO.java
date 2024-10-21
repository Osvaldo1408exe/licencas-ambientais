package com.caj.ecolicencas.dao;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.Tipo;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TipoDAO {
    String sql = "SELECT * FROM tipo WHERE ativo = 's'";

    public List<Tipo> findAll(){
        List<Tipo> Tipos = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Tipo tipo = new Tipo(rs.getInt("id_tipo"), rs.getString("descricao"),rs.getString("ativo"));
                Tipos.add(tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Tipos;
    }
}
