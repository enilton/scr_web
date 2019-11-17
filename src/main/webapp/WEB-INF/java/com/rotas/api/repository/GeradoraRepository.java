package com.rotas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rotas.api.models.Geradora;

@Repository
public interface GeradoraRepository extends JpaRepository<Geradora, Long>{
}
