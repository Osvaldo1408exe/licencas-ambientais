package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.dto.CamposResponseDTO;
import com.caj.ecolicencas.model.entities.*;
import com.caj.ecolicencas.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/campos")
public class CamposController {
    private final AreaService areaService;
    private final ControleService controleService;
    private final EspecificacaoService especificacaoService;
    private final OrgaoEmissorService orgaoEmissorService;
    private final PrevisaoService previsaoService;
    private final ProcessoSeiService processoSeiService;
    private final SetorResponsavlService setorResponsavlService;

    public CamposController(AreaService areaService, ControleService controleService, EspecificacaoService especificacaoService , OrgaoEmissorService orgaoEmissorService, PrevisaoService previsaoService, ProcessoSeiService processoSeiService, SetorResponsavlService setorResponsavlService) {
        this.areaService = areaService;
        this.controleService = controleService;
        this.especificacaoService = especificacaoService;
        this.orgaoEmissorService = orgaoEmissorService;
        this.previsaoService = previsaoService;
        this.processoSeiService = processoSeiService;
        this.setorResponsavlService = setorResponsavlService;
    }

    @GetMapping
    public CamposResponseDTO getAllCampos(){
       List<Area> areas = areaService.getAllActiveAreas();
       List<Controle> controles = controleService.getAllActiveControles();
       List<Especificacao> especificacaos = especificacaoService.findAllActiveEspecificacoes();
       List<OrgaoEmissor> orgaoEmissors = orgaoEmissorService.findAllActiveOrgaosEmissores();
       List<Previsao> previsoes = previsaoService.findAllActivePrevisoes();
       List<ProcessoSei> processos = processoSeiService.findAllActiveProcessos();
       List<SetorResponsavel> setores = setorResponsavlService.findAllActiveSetores();
       return new CamposResponseDTO(areas,controles,especificacaos, orgaoEmissors, previsoes, processos, setores);
    }
}
