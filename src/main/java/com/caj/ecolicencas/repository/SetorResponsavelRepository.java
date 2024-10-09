package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.SetorResponsavel;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SetorResponsavelRepository {
    String sql = "SELECT * FROM setor_responsavel WHERE ativo = 's'";

    public List<SetorResponsavel> findAll(){
        List<SetorResponsavel> setores = new ArrayList<>();
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                SetorResponsavel processo_sei = new SetorResponsavel(rs.getInt("id_setor_responsavel"), rs.getString("descricao"),rs.getString("ativo"));
                setores.add(processo_sei);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setores;
    }
}
