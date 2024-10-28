package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.repository.LicencaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LicencaService {
    private final LicencaRepository licencaRepository;

    public LicencaService(LicencaRepository licencaRepository){
        this.licencaRepository = licencaRepository;
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
            //licenca.setProvidenciarDoc(); fazer método
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
        int unidade = licenca.getUnidade().getId();
        LocalDate data_vencimento = licenca.getDataVencimento() != null ? licenca.getDataVencimento() : null;
        int tipo = licenca.getTipo().getId();
        int previsao = licenca.getPrevisao().getId();

        if (data_vencimento == null){return null;}
        if (unidade == 34){return data_vencimento.minusMonths(3);}
        else if(tipo == 10 && previsao == 4){return data_vencimento.minusMonths(4);}
        else if (tipo == 4 && previsao == 5) {return  data_vencimento.minusMonths(3);}
        else if(previsao == 3 || (tipo == 14 || tipo == 13 || tipo == 8)){return  data_vencimento.minusMonths(4);}
        return data_vencimento;
    }

}
