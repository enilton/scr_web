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
import com.rotas.web.models.Rota;

public class RotaService {

	private final String ROTA = "rota";
	private final Gson gson = new Gson();
	
	public List<Rota> listarTodas() throws IOException{
		

		HttpURLConnection con = API.getAPI(ROTA);
		con.setRequestMethod("GET");
				
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();					
			String responseLine = null;
			
			List<Rota> rotas = new ArrayList<Rota>();
			
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());			
			}			
			
			//int teste = response.length();
			
			//havendo resultado
			if(response.length() != 2) {
				String [] objetoJson = response.toString().split("],");
				
				for (int i = 0; i < objetoJson.length; i++) 
				{
					
					Rota rota = new Rota();
					rota = gson.fromJson(objetoJson[i].toString(), Rota.class);
					rotas.add(rota);
				}					
			}			
			
			return rotas;
		}		
	}

	public Rota criarRota(Rota rota) throws IOException {

		HttpURLConnection con = API.getAPI(ROTA);

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		String jsonInputString = gson.toJson(rota);

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
			//System.out.println(response.toString());
			return gson.fromJson(response.toString(), Rota.class);
		}
	}
}
