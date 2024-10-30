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

    public LicencaService(LicencaRepository licencaRepository, UnidadeRepository unidadeRepository, PrevisaoRepository previsaoRepository, TipoRepository tipoRepository, ControleRepository controleRepository) {
        this.licencaRepository = licencaRepository;
        this.unidadeRepository = unidadeRepository;
        this.previsaoRepository = previsaoRepository;
        this.tipoRepository = tipoRepository;
        this.controleRepository = controleRepository;
    }
    /*FUNÇÕES DE CRUD*/

    //todas as licencas
    public List<Licenca> findAllActiveLicenca(){
        return licencaRepository.findAll();
    }

    public Optional<Licenca> findByLicencaById(int id){
        return licencaRepository.findActiveByIdAndAtivo(id,"s");
    }

    public Licenca insertLicencas(Licenca licenca){
        licenca.setTempoTramitacao(tramitacao(licenca));
        licenca.setDiasParaVencer(diasParaVencer(licenca));
        licenca.setDataLimite(dataLimite(licenca));
        licencaRepository.save(licenca);
        return licenca;
    }

    public Licenca updateLicenca(int id,Licenca licencaAtualizada){
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
            //licenca.setSituacaoLicenca(); fazer o metodo
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
        if(hoje.isBefore(dataVencimento)){
            int diferenca =  (int) ChronoUnit.DAYS.between(hoje,dataVencimento);
            return diferenca;
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
             } else{
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

        if (data_vencimento == null){
            return null;
        }
        else if (unidade.getDescricao().equals("LCQ")){
            return data_vencimento.minusMonths(3);
        }
        else if(tipo.getDescricao().equals("LAO") && previsao.getDescricao().equals("Renovar")){
            return data_vencimento.minusMonths(4);
        }
        else if (tipo.getDescricao().equals("Outorga") && previsao.getDescricao().equals("Não Renovar")) {
            return  data_vencimento.minusMonths(3);
        }
        else if(previsao.getDescricao().equals("Não Prorrogar") || (tipo.getDescricao().equals("LAI") || tipo.getDescricao().equals("LAP") || tipo.getDescricao().equals("LAP/LAI"))){
            return  data_vencimento.minusMonths(4);
        }
        return data_vencimento;
    }

    private LocalDate providenciarDoc(Licenca licenca) {
        LocalDate data_vencimento = licenca.getDataVencimento() != null ? licenca.getDataVencimento() : null;
        Tipo tipo = tipoRepository.getReferenceById(licenca.getTipo().getId());
        Previsao previsao = previsaoRepository.getReferenceById(licenca.getPrevisao().getId());
        Controle controle = controleRepository.getReferenceById(licenca.getControle().getId());

        if (data_vencimento == null) return null;
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
        } else if (tipo.getDescricao().equals("Renovar")) {
            return data_vencimento.minusMonths(1);
        } else {
            return null;
        }
    }



}
