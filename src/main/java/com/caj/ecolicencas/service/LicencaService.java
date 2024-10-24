package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.repository.LicencaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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


    // licenca por id
    public Optional<Licenca> findByLicencaById(int id){
        return licencaRepository.findActiveByIdAndAtivo(id,"s");
    }





    /*FUNÇÕES DE CALCULO*/

    public int diasParaVencer(Licenca licenca){
        LocalDate hoje = LocalDate.now();
        //converte data para localDate
        LocalDate dataVencimento = licenca.getDataVencimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(hoje.isBefore(dataVencimento)){
            Period diferenca = Period.between(hoje,dataVencimento);
            return diferenca.getDays();
        }else{
            return 0;
        }
    }

    public int tramitacao(Licenca licenca){
         LocalDate hoje = LocalDate.now();
         LocalDate dataEmissao = licenca.getDataEmissao().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         LocalDate dataRequerimento = licenca.getDataRequerimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

         if(dataRequerimento != null && dataEmissao == null){
             Period diferenca = Period.between(hoje,dataRequerimento);
             return  diferenca.getDays();
         } else if (dataRequerimento != null) {
             Period diferenca = Period.between(dataEmissao,dataRequerimento);
             return  diferenca.getDays();
         }else {
             return 0;
         }
    }
}
