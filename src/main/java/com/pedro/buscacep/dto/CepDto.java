package com.pedro.buscacep.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CepDto(@JsonAlias ("cep") String cep, 
		@JsonAlias ("logradouro") String Longradouro, 
		@JsonAlias ("complemento") String complemento, 
		@JsonAlias ("unidade")String unidade, 
		@JsonAlias ("bairro")String bairro, 
		@JsonAlias ("localidade")String Localidade, 
		@JsonAlias ("uf") String uf,
		@JsonAlias ("estado") String estado,
		@JsonAlias ("regiao") String regiao, 
		@JsonAlias ("ibge")String ibge, 
		@JsonAlias ("gia")String gia, 
		@JsonAlias ("ddd") String ddd, 
		@JsonAlias ("siafi") String siafi) {

}
