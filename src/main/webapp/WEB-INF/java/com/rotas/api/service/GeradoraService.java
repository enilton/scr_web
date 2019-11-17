package com.rotas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rotas.api.models.Geradora;
import com.rotas.api.repository.GeradoraRepository;

@Service
public class GeradoraService {

	@Autowired
	private GeradoraRepository geradoraRepository;

	public List<Geradora> findAll() {
		return geradoraRepository.findAll();
	}

	public Geradora findById(final Long id) {
		return geradoraRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	public Geradora save(Geradora geradora) {
		return geradoraRepository.save(geradora);
	}
	
	public void deleteById(final Long id) {
		geradoraRepository.deleteById(id);
	}
}
