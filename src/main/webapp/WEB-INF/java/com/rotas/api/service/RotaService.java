package com.rotas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotas.api.models.Rota;
import com.rotas.api.repository.RotaRepository;

@Service
public class RotaService {

	@Autowired
	private RotaRepository rotaRepository;

	public List<Rota> findAll() {
		return rotaRepository.findAll();
	}

	public Rota findById(final Long id) {
		return rotaRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	public Rota save(Rota rota) {
		return rotaRepository.save(rota);
	}
	
	public void deleteById(final Long id) {
		rotaRepository.deleteById(id);
	}
}
