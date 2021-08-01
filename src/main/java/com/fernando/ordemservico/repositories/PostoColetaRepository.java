package com.fernando.ordemservico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.ordemservico.domain.PostoColeta;

@Repository
public interface PostoColetaRepository extends JpaRepository<PostoColeta, Integer> {

}
