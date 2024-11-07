package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.*;
import com.caj.ecolicencas.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LicencaService {
    private final LicencaRepository licencaRepository;
    private final UnidadeRepository unidadeRepository;
    private final PrevisaoRepository previsaoRepository;
    private final TipoRepository tipoRepository;
    private final ControleRepository controleRepository;
    private final SituacaoProcessoRepository situacaoProcessoRepository;
    private final SimNaoRepository simNaoRepository;
    private final SituacaoLicencaRepository situacaoLicencaRepository;
    private final HistoricoObsService historicoObsService;

    public LicencaService(LicencaRepository licencaRepository, UnidadeRepository unidadeRepository, PrevisaoRepository previsaoRepository, TipoRepository tipoRepository, ControleRepository controleRepository, SituacaoProcessoRepository situacaoProcessoRepository, SimNaoRepository simNaoRepository, SituacaoLicencaRepository situacaoLicencaRepository, HistoricoObsService historicoObsService) {
        this.licencaRepository = licencaRepository;
        this.unidadeRepository = unidadeRepository;
        this.previsaoRepository = previsaoRepository;
        this.tipoRepository = tipoRepository;
        this.controleRepository = controleRepository;
        this.situacaoProcessoRepository = situacaoProcessoRepository;
        this.simNaoRepository = simNaoRepository;
        this.situacaoLicencaRepository = situacaoLicencaRepository;
        this.historicoObsService = historicoObsService;
    }
    /*FUNÇÕES DE CRUD*/

    //todas as licencas
    public List<Licenca> findAllActiveLicenca(){
        return licencaRepository.findAll();
    }

    public Optional<Licenca> findByLicencaById(int id){
        return licencaRepository.findActiveByIdAndAtivo(id,"s");
    }

    public Licenca insertLicencas(Licenca licenca, Usuario usuario){

        //adiciona a licenca
        licenca.setTempoTramitacao(tramitacao(licenca));
        licenca.setDiasParaVencer(diasParaVencer(licenca));
        licenca.setDataLimite(dataLimite(licenca));
        licencaRepository.save(licenca);

        //salva as observações da licenca
        historicoObsService.insertHistorico(licenca,usuario);


        return licenca;
    }

    public Licenca updateLicenca(int id,Licenca licencaAtualizada, Usuario usuario){

        //atualiza a licença
        Optional<Licenca> licencaExistente = licencaRepository.findById(id);
        if (licencaExistente.isPresent()){
            Licenca licenca = licencaExistente.get();

            licenca.setArea(licencaAtualizada.getArea());
            licenca.setUnidade(licencaAtualizada.getUnidade());
            licenca.setSubUnidade(licencaAtualizada.getSubUnidade());
            licenca.setDataRequerimento(licencaAtualizada.getDataRequerimento());
            licenca.setControle(licencaAtualizada.getControle());
            licenca.setOrgao(licencaAtualizada.getOrgao());
            licenca.setTipo(licencaAtualizada.getTipo());
            licenca.setEspecificacao(licencaAtualizada.getEspecificacao());
            licenca.setPrevisao(licencaAtualizada.getPrevisao());
            licenca.setRequerimento(licencaAtualizada.getRequerimento());
            licenca.setEmitidaNovaLicenca(licencaAtualizada.getEmitidaNovaLicenca());
            licenca.setSituacaoProcesso(licencaAtualizada.getSituacaoProcesso());
            licenca.setAtualizadoSa(licencaAtualizada.getAtualizadoSa());
            licenca.setSituacaoLicenca(situacaoLicenca(licencaAtualizada));
            licenca.setSetorResponsavel(licencaAtualizada.getSetorResponsavel());
            licenca.setNumLicenca(licencaAtualizada.getNumLicenca());
            licenca.setFceiSinfat(licencaAtualizada.getFceiSinfat());
            licenca.setNumProcessoSinfat(licencaAtualizada.getNumProcessoSinfat());
            licenca.setSgpe(licencaAtualizada.getSgpe());
            licenca.setProcessoSei(licencaAtualizada.getProcessoSei());
            licenca.setDataEmissao(licencaAtualizada.getDataEmissao());
            licenca.setDataVencimento(licencaAtualizada.getDataVencimento());
            licenca.setDataProcotoloOrgao(licencaAtualizada.getDataProcotoloOrgao());
            licenca.setObservacoes(licencaAtualizada.getObservacoes());
            licenca.setProvidenciarDoc(providenciarDoc(licencaAtualizada));
            licenca.setDataLimite(dataLimite(licencaAtualizada));
            licenca.setTempoTramitacao(tramitacao(licencaAtualizada));
            licenca.setDiasParaVencer(diasParaVencer(licencaAtualizada));

            //salva as observações da licenca
            historicoObsService.insertHistorico(licencaAtualizada,usuario);


            return licencaRepository.save(licenca);
        }else{
            throw new RuntimeException("Licenca ID: "+id+" não foi encontrada");
        }
    };

    public Licenca deleteLicencas(int id){
        Licenca licenca = licencaRepository.getReferenceById(id);
        licenca.setAtivo("n");
        licencaRepository.save(licenca);
        return licenca;
    }



    /*FUNÇÕES DE CALCULO*/

    private int diasParaVencer(Licenca licenca){
        LocalDate hoje = LocalDate.now();
        //converte data para localDate
        LocalDate dataVencimento = licenca.getDataVencimento();
        if (dataVencimento == null){
            return 0;
        }
        if(hoje.isBefore(dataVencimento)){
            return (int) ChronoUnit.DAYS.between(hoje,dataVencimento);
        }else{
            return 0;
        }
    }

    private int tramitacao(Licenca licenca){
         LocalDate hoje = LocalDate.now();
         LocalDate dataEmissao = licenca.getDataEmissao() != null ? licenca.getDataEmissao() : null;
         LocalDate dataRequerimento = licenca.getDataRequerimento() != null ? licenca.getDataRequerimento() : null;

         if (dataRequerimento != null){
             if(dataEmissao == null){
                 return (int) ChronoUnit.DAYS.between(dataRequerimento,hoje);
             }else{
                 return (int) ChronoUnit.DAYS.between(dataRequerimento, dataEmissao);
             }
         }else{
             return 0;
         }
    }

    private LocalDate dataLimite(Licenca licenca){
        Unidade unidade = unidadeRepository.getReferenceById(licenca.getUnidade().getId());
        LocalDate data_vencimento = licenca.getDataVencimento() != null ? licenca.getDataVencimento() : null;
        Tipo tipo = tipoRepository.getReferenceById(licenca.getTipo().getId());
        Previsao previsao = previsaoRepository.getReferenceById( licenca.getPrevisao().getId());

        if (data_vencimento == null){return null;}
        else if (unidade.getDescricao().equals("LCQ")){return data_vencimento.minusMonths(3);}
        else if(tipo.getDescricao().equals("LAO") && previsao.getDescricao().equals("Renovar")){return data_vencimento.minusMonths(4);}
        else if (tipo.getDescricao().equals("Outorga") && previsao.getDescricao().equals("Não Renovar")) {return  data_vencimento.minusMonths(3);}
        else if(previsao.getDescricao().equals("Não Prorrogar") || (tipo.getDescricao().equals("LAI") || tipo.getDescricao().equals("LAP") || tipo.getDescricao().equals("LAP/LAI"))){return  data_vencimento.minusMonths(4);}
        return data_vencimento;
    }


    private LocalDate providenciarDoc(Licenca licenca) {
        LocalDate data_vencimento =  licenca.getDataVencimento() ;
        Tipo tipo = tipoRepository.getReferenceById(licenca.getTipo().getId());
        Previsao previsao = previsaoRepository.getReferenceById(licenca.getPrevisao().getId());
        Controle controle = controleRepository.getReferenceById(licenca.getControle().getId());

        if (data_vencimento == null){
            return null;
        }
        else if (controle.getDescricao().equals("Condicionante") || controle.getDescricao().equals("Info_Complementar") || previsao.getDescricao().equals("Prorrogar")) {
            return data_vencimento.minusMonths(1);
        } else if (previsao.getDescricao().equals("Não Prorrogar") || (tipo.getDescricao().equals("LAI") || tipo.getDescricao().equals("LAP") || tipo.getDescricao().equals("LAP/LAI"))) {
            return data_vencimento.minusMonths(6);
        } else if (tipo.getDescricao().equals("AuA")) {
            return data_vencimento.minusMonths(3);
        } else if (tipo.getDescricao().equals("LAO")) {
            return data_vencimento.minusMonths(6);
        } else if (tipo.getDescricao().equals("Outorga")) {
            return data_vencimento.minusMonths(4);
        } else if (previsao.getDescricao().equals("Renovar")) {
            return data_vencimento.minusMonths(1);
        } else {
            return null;
        }
    }


    //Função do campo de situações
    private SituacaoLicenca situacaoLicenca(Licenca licenca){
        Unidade unidade = unidadeRepository.getReferenceById(licenca.getUnidade().getId());
        LocalDate data_emissao = licenca.getDataEmissao() != null ? licenca.getDataEmissao() : null;
        LocalDate data_vencimento = licenca.getDataVencimento() != null ? licenca.getDataVencimento() : null;
        Tipo tipo = tipoRepository.getReferenceById(licenca.getTipo().getId());
        Previsao previsao = previsaoRepository.getReferenceById(licenca.getPrevisao().getId());
        Controle controle = controleRepository.getReferenceById(licenca.getControle().getId());
        SituacaoProcesso situacao_processo = situacaoProcessoRepository.getReferenceById(licenca.getSituacaoProcesso().getId());
        SimNao emitidaNovaLicenca = simNaoRepository.getReferenceById(licenca.getEmitidaNovaLicenca().getId());
        SimNao requerimento = simNaoRepository.getReferenceById(licenca.getRequerimento().getId());
        LocalDate providenciarDoc =  providenciarDoc(licenca);
        LocalDate dataLimite = dataLimite(licenca);
        LocalDate dataAtual = LocalDate.now();


        if (unidade.getDescricao().equals("-")){
            return situacaoLicencaRepository.findByDescricao("Inválida");
        }
        if(data_emissao == null){
            return situacaoLicencaRepository.findByDescricao("Aguardando análise");
        }
        if(previsao.getDescricao().equals("Resolução alterada - Porte inferior a P")){
            return situacaoLicencaRepository.findByDescricao("Resolução alterada - Porte inferior a P");
        }
        if (situacao_processo.getDescricao().equals("Concluído") && (emitidaNovaLicenca.getDescricao().equals("NÃO") || emitidaNovaLicenca.getDescricao().equals("NA"))) {
            return situacaoLicencaRepository.findByDescricao("Processo Concluído");
        }
        if (previsao.getDescricao().equals("Não Prorrogar") || previsao.getDescricao().equals("Não Renovar") || previsao.getDescricao().equals("-")){
            if (dataAtual.isBefore(data_vencimento)) {
                return situacaoLicencaRepository.findByDescricao("Vigente");
            } else {
                return situacaoLicencaRepository.findByDescricao("Inválida");
            }
        }
        //rota caso a licença seja do tipo Autorização
        if (controle.getDescricao().equals("Autorização")){
            if (requerimento.getDescricao().equals("SIM") && !situacao_processo.getDescricao().equals("Concluído") &&
                    (previsao.getDescricao().equals("Prorrogar") || previsao.getDescricao().equals("Renovar"))){
               return situacaoLicencaRepository.findByDescricao("Em renovação");
            }else if (requerimento.getDescricao().equals("SIM") || previsao.getDescricao().equals("Prorrogar") || previsao.getDescricao().equals("Renovar")) {
                if (dataAtual.isBefore(providenciarDoc)){
                    return situacaoLicencaRepository.findByDescricao("Vigente");
                }else if(dataAtual.isBefore(dataLimite)){
                    return situacaoLicencaRepository.findByDescricao("Vigente - Providenciar Documentos");
                }else {
                    return situacao_processo.getDescricao().equals("Concluído") ?
                            situacaoLicencaRepository.findByDescricao("Inválida") : situacaoLicencaRepository.findByDescricao("Vencida");
                }
            }
        }

        //rota caso a licença seja do tipo Licenciamento
        if (controle.getDescricao().equals("Licenciamento")){
            if (emitidaNovaLicenca.getDescricao().equals("SIM") || situacao_processo.getDescricao().equals("Concluído")){
                return situacaoLicencaRepository.findByDescricao("Inválida");
            }else if(previsao.getDescricao().equals("Não Renovar") && dataAtual.isBefore(data_vencimento)){
                return situacaoLicencaRepository.findByDescricao("Vigente");
            }else if (requerimento.getDescricao().equals("SIM") && previsao.getDescricao().equals("Prorrogar")){
                if (dataAtual.isBefore(providenciarDoc)){
                    return situacaoLicencaRepository.findByDescricao("Vigente");
                } else if (dataAtual.isBefore(dataLimite)) {
                    return situacaoLicencaRepository.findByDescricao("Vigente - Providenciar Documentos");
                }else {
                    return dataAtual.isBefore(data_vencimento) ?
                            situacaoLicencaRepository.findByDescricao("Prazo extrapolado") : situacaoLicencaRepository.findByDescricao("Vencida");
                }
            }
        }
        if (controle.getDescricao().equals("Condicionante") || controle.getDescricao().equals("Info_Complementar")){
            if (dataAtual.isBefore(providenciarDoc)){
                return situacaoLicencaRepository.findByDescricao("No prazo - Aguardando providências!");
            }else {
                return dataAtual.isBefore(dataLimite) ?
                        situacaoLicencaRepository.findByDescricao("No Prazo - Preparar protocolo!") : situacaoLicencaRepository.findByDescricao("Adotar Providências");
            }
        }
        if (controle.getDescricao().equals("Protocolo")){
            return  situacaoLicencaRepository.findByDescricao("Retorno de Protocolo");
        }
       else return situacaoLicencaRepository.findByDescricao("ERRO");
    }



}
