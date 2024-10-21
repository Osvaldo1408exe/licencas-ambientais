package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.OrgaoEmissor;
import com.caj.ecolicencas.dao.OrgaoEmissorDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgaoEmissorService {
    private final OrgaoEmissorDAO orgaoEmissorDAO;

    public OrgaoEmissorService(OrgaoEmissorDAO orgaoEmissorDAO){
        this.orgaoEmissorDAO = orgaoEmissorDAO;
    }

    public List<OrgaoEmissor> findAllActiveOrgaosEmissores(){
        return orgaoEmissorDAO.fingAll();
    }
}
