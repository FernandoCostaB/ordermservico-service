package com.fernando.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.ordemservico.domain.OrdemServicoExame;

@Repository
public interface OrdemServicoExameRepository extends JpaRepository<OrdemServicoExame, Integer>{

}
