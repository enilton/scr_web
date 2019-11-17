package com.rotas.web.config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {
	
	public static HttpURLConnection getAPI(String rota) throws IOException {
		URL url = new URL("http://localhost:8080/api/" + rota);
        return (HttpURLConnection) url.openConnection();
	}

}
