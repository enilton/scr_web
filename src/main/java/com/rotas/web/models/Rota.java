package com.rotas.web.models;

import java.util.List;

public class Rota {
	
	private long id;
	
	private String nome;	
	
	private List<Geradora> geradoras;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Geradora> getGeradoras() {
		return geradoras;
	}

	public void setGeradoras(List<Geradora> geradoras) {
		this.geradoras = geradoras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geradoras == null) ? 0 : geradoras.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rota other = (Rota) obj;
		if (geradoras == null) {
			if (other.geradoras != null)
				return false;
		} else if (!geradoras.equals(other.geradoras))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}	
}
