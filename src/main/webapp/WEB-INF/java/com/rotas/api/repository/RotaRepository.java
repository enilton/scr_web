package com.rotas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rotas.api.models.Rota;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long>{

	Rota findById(long id);
	
}
