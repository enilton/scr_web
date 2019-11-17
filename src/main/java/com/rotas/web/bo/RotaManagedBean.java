package com.rotas.web.bo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.rotas.web.models.Rota;
import com.rotas.web.service.RotaService;

@ManagedBean(name="rotaBean")
@SessionScoped
public class RotaManagedBean implements java.io.Serializable {	

	private static final long serialVersionUID = -7140024963900730475L;

	private Rota rota = new Rota();

	private List<Rota> rotas;

	private String mensagem;
	
	public void listarTodas() {
		try {
			RotaService rotaService = new RotaService();
			this.setRotas(rotaService.listarTodas());			
			this.setMensagem("Rotas Carregadas ");
		} catch (Exception e) {
			this.setMensagem("Falha ao carregar rotas: " + e.getMessage());			
		}	
	}
	
	public void incluir() {	
		try {
			RotaService rotaService = new RotaService();
			this.rotas.add(rotaService.criarRota(this.rota));
			rota = new Rota(); 
			this.setMensagem("Rota Criada");
		} catch (Exception e) {
			this.setMensagem("Falha ao incluir rota: " + e.getMessage());			
		}		
	}
	
	public void setNome(String nome) {
		this.rota.setNome(nome);
	}
	
	public String getNome() {
		return this.rota.getNome();
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
