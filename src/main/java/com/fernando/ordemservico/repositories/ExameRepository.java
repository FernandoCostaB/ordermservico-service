package com.fernando.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.ordemservico.domain.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer>{

}
