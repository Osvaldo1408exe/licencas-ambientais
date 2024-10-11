package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.SimNao;
import com.caj.ecolicencas.model.entities.SituacaoLicenca;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SituacaoLicencaRepository {
    String sql = "SELECT * FROM situacao_licenca WHERE ativo = 's'";

    public List<SituacaoLicenca> findAll(){
        List<SituacaoLicenca> situacaoLicencas = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                SituacaoLicenca situacao_licenca = new SituacaoLicenca(rs.getInt("id_situacao_licenca"), rs.getString("descricao"),rs.getString("ativo"));
                situacaoLicencas.add(situacao_licenca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return situacaoLicencas;
    }
}
