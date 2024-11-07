package com.caj.ecolicencas.repository;

import com.caj.ecolicencas.model.entities.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Logs, Integer> {
}
