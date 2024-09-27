package com.pedro.buscacep.model;

import com.pedro.buscacep.dto.CepDto;

public class Cep {

	private String cepFormatado;
	private String complemento;

	public Cep(CepDto fromJson) {

		this.cepFormatado = fromJson.cep();
		this.complemento = fromJson.complemento();
	}

	public String getCepFormatado() {
		return cepFormatado;
	}

	public String getComplemento() {
		return complemento;
	}

	@Override
	public String toString() {
		return "cep: " + cepFormatado + ", complemento: " + complemento;
	}
	
	public String info() {
		return "Informações\n"+ toString();
	}

	
}
