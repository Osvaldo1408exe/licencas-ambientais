package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.Controle;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ControleRepository {
    String sql = "SELECT * FROM controle WHERE ativo = 's'";

    public List<Controle> findAll(){
        List<Controle> controles = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Controle controle = new Controle(rs.getInt("id_controle"),rs.getString("descricao"),rs.getString("ativo") );
                controles.add(controle);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return controles;
    }
}
