package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.OrgaoEmissor;
import com.caj.ecolicencas.repository.OrgaoEmissorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgaoEmissorService {
    private final OrgaoEmissorRepository orgaoEmissorRepository;

    public OrgaoEmissorService(OrgaoEmissorRepository orgaoEmissorRepository){
        this.orgaoEmissorRepository = orgaoEmissorRepository;
    }

    public List<OrgaoEmissor> findAllActiveOrgaosEmissores(){
        return orgaoEmissorRepository.findAll();
    }
}
