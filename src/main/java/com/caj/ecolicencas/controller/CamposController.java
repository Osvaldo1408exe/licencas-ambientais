package com.caj.ecolicencas.controller;

import com.caj.ecolicencas.dto.CamposResponseDTO;
import com.caj.ecolicencas.model.entities.*;
import com.caj.ecolicencas.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/campos")
public class CamposController {
    private final AreaService areaService;
    private final ControleService controleService;
    private final EspecificacaoService especificacaoService;
    private final OrgaoEmissorService orgaoEmissorService;
    private final PrevisaoService previsaoService;
    private final SetorResponsavelService setorResponsavelService;
    private final SimNaoService simnaoService;
    private final SituacaoLicencaService situacoesLicencasService;
    private final SituacaoProcessoService situcoesProcessosService;
    private final SubUnidadeService subUnidadesService;
    private final TipoService tiposService;
    private final UnidadeService unidadesService;


    public CamposController(AreaService areaService, ControleService controleService, EspecificacaoService especificacaoService, OrgaoEmissorService orgaoEmissorService, PrevisaoService previsaoService, SetorResponsavelService setorResponsavelService, SimNaoService simnaoService, SituacaoLicencaService situacoesLicencasService, SituacaoProcessoService situcoesProcessosService, SubUnidadeService subUnidadesService, TipoService tiposService, UnidadeService unidadesService) {
        this.areaService = areaService;
        this.controleService = controleService;
        this.especificacaoService = especificacaoService;
        this.orgaoEmissorService = orgaoEmissorService;
        this.previsaoService = previsaoService;
        this.setorResponsavelService = setorResponsavelService;
        this.simnaoService = simnaoService;
        this.situacoesLicencasService = situacoesLicencasService;
        this.situcoesProcessosService = situcoesProcessosService;
        this.subUnidadesService = subUnidadesService;
        this.tiposService = tiposService;
        this.unidadesService = unidadesService;
    }

    @GetMapping
    public ResponseEntity<CamposResponseDTO> getAllCampos(){
        try {
            List<Area> areas = areaService.getAllActiveAreas();
            List<Controle> controles = controleService.getAllActiveControles();
            List<Especificacao> especificacaos = especificacaoService.findAllActiveEspecificacoes();
            List<OrgaoEmissor> orgaoEmissors = orgaoEmissorService.findAllActiveOrgaosEmissores();
            List<Previsao> previsoes = previsaoService.findAllActivePrevisoes();
            List<SetorResponsavel> setores = setorResponsavelService.findAllActiveSetores();
            List<SimNao> simnaos = simnaoService.findAllActiveSimNaos();
            List<SituacaoLicenca> situacoesLicencas = situacoesLicencasService.findAllActiveSituacaoLicencas();
            List<SituacaoProcesso> situcoesProcessos= situcoesProcessosService.findAllActivSituacaoProcesso();
            List<SubUnidade> subUnidades = subUnidadesService.findAllActiveSubUnidade();
            List<Tipo> tipos = tiposService.findAllActiveTipo();
            List<Unidade> unidades = unidadesService.findAllActivUnidade();


            CamposResponseDTO response = new CamposResponseDTO(areas,controles,especificacaos, orgaoEmissors, previsoes, setores, simnaos, situacoesLicencas, situcoesProcessos, subUnidades, tipos, unidades);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return (ResponseEntity<CamposResponseDTO>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
