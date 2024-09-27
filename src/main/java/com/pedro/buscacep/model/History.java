package com.pedro.buscacep.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

public class History {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime dataHora;
	private String cep;

	public History() {
	}
	public History(LocalDateTime dataHora, String cep) {
		this.dataHora = dataHora;
		this.cep = cep;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {

		return getDateFormat() + " , Cep: " + cep;
	}

	private String getDateFormat() {

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String[] dataFormatada = format.format(dataHora).split(" ");
		
		return "Data: " + dataFormatada[0] + " Hora: " + dataFormatada[1];
	}

}
