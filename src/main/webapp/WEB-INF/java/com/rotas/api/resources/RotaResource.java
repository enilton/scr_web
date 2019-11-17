package com.rotas.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rotas.api.models.Rota;
import com.rotas.api.repository.RotaRepository;

@RestController
public class RotaResource {
	
	@Autowired
	RotaRepository rotaRepository;
	
	@GetMapping("/rota")
	public List<Rota> listarTodos(){
		return rotaRepository.findAll();
	}
	
	@GetMapping("/rota/{id}")
    public Rota ObterPorId(@PathVariable(value = "id") long id)
    {
        return rotaRepository.findById(id);
    }
	
	@PostMapping("/rota")
	public Rota Salvar(@RequestBody Rota rota) {
		return rotaRepository.save(rota);
	}
	
	@DeleteMapping("/rota/{id}")
    public void Remover(@PathVariable(value = "id") long id)
    {
        rotaRepository.deleteById(id);
    }
	
	@PutMapping("/rota")
	public Rota Atualizar(@RequestBody Rota rota) {
		return rotaRepository.save(rota);
	}

}
