package com.caj.ecolicencas.service;

import com.caj.ecolicencas.model.entities.Licenca;
import com.caj.ecolicencas.dao.LicencaDAO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LicencaService {
    private final LicencaDAO licencaDAO;

    public LicencaService(LicencaDAO licencaDAO){
        this.licencaDAO = licencaDAO;
    }

    /*FUNÇÕES DE CRUD*/

    //retorna todas as licencas
    public List<Licenca> findAllActiveLicenca(){
        return licencaDAO.findAll();
    }
    //retorna a licenca pelo id enviado
    public Optional<Licenca> findActiveById(int id){
        return  licencaDAO.findById(id);
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
















}
