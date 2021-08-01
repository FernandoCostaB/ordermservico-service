package com.fernando.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.ordemservico.domain.Paciente;

@Repository
public interface PacienteRepository  extends JpaRepository<Paciente, Integer>{

}
