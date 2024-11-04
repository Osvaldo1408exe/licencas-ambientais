package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.model.entities.Licenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LicencaRepository extends JpaRepository<Licenca, Integer> {

    Optional<Licenca> findActiveByIdAndAtivo(int id,String ativo);


}
