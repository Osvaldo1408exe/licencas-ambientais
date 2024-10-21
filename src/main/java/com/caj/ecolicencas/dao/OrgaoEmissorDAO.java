package com.caj.ecolicencas.dao;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.OrgaoEmissor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrgaoEmissorDAO {
    String sql = "SELECT * FROM orgao_emissor WHERE ativo = 's'";

    public List<OrgaoEmissor> fingAll(){
        List<OrgaoEmissor> orgaoEmissors = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                OrgaoEmissor orgaoEmissor = new OrgaoEmissor(rs.getInt("id_orgao_emissor"),rs.getString("descricao"),rs.getString("ativo"));
                orgaoEmissors.add(orgaoEmissor);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return orgaoEmissors;
    }
}
