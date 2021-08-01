package com.fernando.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.ordemservico.domain.Medico;

@Repository
public interface MedicoRepository  extends JpaRepository<Medico, Integer>{

}