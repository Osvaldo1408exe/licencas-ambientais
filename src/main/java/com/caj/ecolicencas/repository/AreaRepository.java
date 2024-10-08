package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.Area;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AreaRepository {
    String sql = "SELECT * FROM area WHERE ativo = 's' ";

    public List<Area> findAll(){
        List<Area> areas = new ArrayList<>();
        try{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Area area = new Area( rs.getInt("id_area"),rs.getString("descricao"), rs.getString("ativo"));
                areas.add(area);
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return areas;
    }
}
