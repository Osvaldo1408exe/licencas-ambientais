package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.config.ConnectionFactory;
import com.caj.ecolicencas.model.entities.Licenca;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class LicencaRepository {
    private String sql = "SELECT  licencas.id_licenca, area.descricao as area, unidade.descricao as unidade, sub_unidade.descricao as subUnidade, licencas.data_requerimento, \n" +
            "\t\tcontrole.descricao as controle, orgao_emissor.descricao as orgao_emissor, tipo.descricao as tipo, especificacao.descricao as especificacao, \n" +
            "\t\tnumero_licenca, fcei_sinfat, num_processo_sinfat, sgpe,  processo_sei.descricao as processo_sei, data_emissao, data_vencimento, previsao.descricao as previsao,\n" +
            "\t\tsim_nao.descricao as requerimento, data_protocolo_orgao, sim_nao.descricao as emitida_nova_licenca, situacao_processo.descricao as situacao_processo,\n" +
            "\t\tsim_nao.descricao as atualizad_sa, observacoes, providenciar_doc, data_limite, tempo_tramitacao, situacao_licenca.descricao as situacao_licenca,\n" +
            "\t\tsetor_responsavel.descricao as setor_responsavel, dias_para_vencer, licencas.ativo\n" +
            "FROM licencas\n" +
            "join area on licencas.id_area = area.id_area\n" +
            "join unidade ON unidade.id_unidade = licencas.id_unidade\n" +
            "join sub_unidade ON sub_unidade.id_subunidade = licencas.id_subunidade\n" +
            "join controle ON controle.id_controle = licencas.id_controle\n" +
            "join orgao_emissor ON orgao_emissor.id_orgao_emissor = licencas.id_orgao\n" +
            "join tipo ON tipo.id_tipo = licencas.id_tipo\n" +
            "join especificacao ON especificacao.id_especificacao = licencas.id_especificacao\n" +
            "join processo_sei ON processo_sei.id_processo_sei = licencas.id_num_processo_sei\n" +
            "join previsao ON previsao.id_previsao = licencas.id_previsao\n" +
            "join sim_nao ON sim_nao.id_sim_nao = licencas.id_atualizado_sa\n" +
            "join sim_nao sim_nao2 ON sim_nao2.id_sim_nao = licencas.id_emitida_nova_licenca\n" +
            "join sim_nao sim_nao3 ON sim_nao3.id_sim_nao = licencas.id_requerimento \n" +
            "join situacao_processo ON situacao_processo.id_situacao_processo = licencas.id_situacao_processo\n" +
            "join setor_responsavel ON setor_responsavel.id_setor_responsavel = licencas.id_setor_responsavel\n" +
            "join situacao_licenca ON situacao_licenca.id_situacao_licenca = licencas.id_situacao_licenca\n";

    public List<Licenca> findAll(){
        List<Licenca> licencas = new ArrayList<>();

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Licenca licenca = new Licenca(rs.getInt("id_licenca"), rs.getString("area"),rs.getString("unidade"),rs.getString("subunidade"),
                        rs.getDate("data_requerimento"),rs.getString("controle"), rs.getString("orgao_emissor"), rs.getString("tipo"), rs.getString("especificacao"),
                        rs.getString("numero_licenca"),rs.getInt("fcei_sinfat"), rs.getString("num_processo_sinfat"), rs.getString("sgpe"), rs.getString("processo_sei"),
                        rs.getDate("data_emissao"), rs.getDate("data_vencimento"), rs.getString("previsao"), rs.getString("requerimento"), rs.getDate("data_protocolo_orgao"),
                        rs.getString("emitida_nova_licenca"), rs.getString("situacao_processo"), rs.getString("atualizad_sa"), rs.getString("observacoes"), rs.getDate("providenciar_doc"),
                        rs.getDate("data_limite"), rs.getInt("tempo_tramitacao"), rs.getString("situacao_licenca"), rs.getString("setor_responsavel"), rs.getInt("dias_para_vencer"),
                        rs.getString("ativo")  );
                licencas.add(licenca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return licencas;
    }


}
