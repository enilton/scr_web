package com.rotas.web.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.rotas.web.config.API;
import com.rotas.web.models.Geradora;

public class GeradoraService {

	private final String ROTA = "geradora";
	private final Gson gson = new Gson();
	
	public List<Geradora> listarTodas() throws IOException{
		

		HttpURLConnection con = API.getAPI(ROTA);
		con.setRequestMethod("GET");
				
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();					
			String responseLine = null;
			
			List<Geradora> geradoras = new ArrayList<Geradora>();
			
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());			
			}			
			
			//int teste = response.length();
			
			//havendo resultado
			if(response.length() != 2) {
				String [] objetoJson = response.toString().split("],");
				
				for (int i = 0; i < objetoJson.length; i++) 
				{
					
					Geradora geradora = new Geradora();
					geradora = gson.fromJson(objetoJson[i].toString(), Geradora.class);
					geradoras.add(geradora);
				}					
			}			
			
			return geradoras;
		}		
	}

	public Geradora criarGeradora(Geradora geradora) throws IOException {

		HttpURLConnection con = API.getAPI(ROTA);

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		String jsonInputString = gson.toJson(geradora);

		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			
			return gson.fromJson(response.toString(), Geradora.class);
		}
	}
}
