package com.rotas.web.bo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.rotas.web.models.Geradora;
import com.rotas.web.service.GeradoraService;

@ManagedBean(name="geradoraBean")
@SessionScoped
public class GeradoraManagedBean implements java.io.Serializable {

	private static final long serialVersionUID = 6644540029890859715L;

	private Geradora geradora = new Geradora();

	private List<Geradora> geradoras;

	private String mensagem;
	
	public void listarTodas() {
		try {
			GeradoraService geradoraService = new GeradoraService();
			this.setGeradoras(geradoraService.listarTodas());			
			this.setMensagem("Geradoras Carregadas ");
		} catch (Exception e) {
			//tratamemto de mensagem temporário
			this.setMensagem("Falha ao carregar geradoras: " + e.getMessage());			
		}	
	}
	
	public void incluir() {	
		try {
			GeradoraService geradoraService = new GeradoraService();
			this.geradoras.add(geradoraService.criarGeradora(this.geradora));
			geradora = new Geradora(); 
			this.setMensagem("Geradora Criada");
		} catch (Exception e) {
			//tratamemto de mensagem temporário
			this.setMensagem("Falha ao incluir geradora: " + e.getMessage());			
		}		
	}
	
	public void setNome(String nome) {
		this.geradora.setNome(nome);
	}
	
	public String getNome() {
		return this.geradora.getNome();
	}

	public Geradora getGeradora() {
		return geradora;
	}

	public void setGeradora(Geradora geradora) {
		this.geradora = geradora;
	}

	public List<Geradora> getGeradoras() {
		return geradoras;
	}

	public void setGeradoras(List<Geradora> geradoras) {
		this.geradoras = geradoras;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
