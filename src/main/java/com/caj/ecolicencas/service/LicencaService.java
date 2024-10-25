package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.repository.LicencaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
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
            licenca.setObservacoes("Teste inserção via jpa/hibernate");
            //licenca.setProvidenciarDoc(); fazer método
            //licenca.setDataLimite() fazer metodo
            licenca.setTempoTramitacao(tramitacao(licencaAtualizada));
            licenca.setDiasParaVencer(diasParaVencer(licencaAtualizada));

            return licencaRepository.save(licenca);
        }else{
            throw new RuntimeException("Licenca ID: "+id+" não foi encontrada");
        }
    };







    /*FUNÇÕES DE CALCULO*/

    public int diasParaVencer(Licenca licenca){
        LocalDate hoje = LocalDate.now();
        //converte data para localDate
        LocalDate dataVencimento = licenca.getDataVencimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(hoje.isBefore(dataVencimento)){
            int diferenca =  (int) ChronoUnit.DAYS.between(hoje,dataVencimento);
            return diferenca;
        }else{
            return 0;
        }
    }

    public int tramitacao(Licenca licenca){
         LocalDate hoje = LocalDate.now();
         LocalDate dataEmissao = licenca.getDataEmissao() != null ? licenca.getDataEmissao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
         LocalDate dataRequerimento = licenca.getDataRequerimento() != null ? licenca.getDataRequerimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;

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


}
