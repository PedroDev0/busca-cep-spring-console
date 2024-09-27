package com.pedro.buscacep.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.pedro.buscacep.dto.CepDto;
import com.pedro.buscacep.exceptions.CepException;
import com.pedro.buscacep.model.Cep;

public class CepService {

	private HttpClient client;
	private HttpRequest request;
	private JsonService service;

	public CepService() {
		this.client = HttpClient.newHttpClient();
		this.service = new JsonService();
	}

	public Cep getCep(String cepCode) throws IOException, InterruptedException, CepException {

		this.request = HttpRequest.newBuilder()
				.uri(URI.create(com.pedro.buscacep.environments.Environment.API_URL + cepCode + "/json")).build();
		HttpResponse<String> cepString = this.client.send(request, BodyHandlers.ofString());

		if (cepString.statusCode() > 299) {
			throw new CepException("Verifique se o cep está digitado corretamente e tente novamente.");
		}

		CepDto dto = service.jsonToObject(cepString.body(), CepDto.class);
		return new Cep(dto);
	}

}
