package com.pedro.buscacep.services;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pedro.buscacep.interfaces.MapperJson;

public class JsonService implements MapperJson {

	private ObjectMapper mapper;

	public JsonService() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
	}

	@Override
	public <T> T jsonToObject(String json, Class<T> clazz) throws JsonMappingException, JsonProcessingException {
		return mapper.readValue(json, clazz);
	}

	@Override
	public <T> T objectToJson(String json, Class<T> clazz) throws JsonMappingException, JsonProcessingException {
		return mapper.readValue(json, clazz);
	}

	@Override
	public <T> List<T> jsonToList(String json,Class<T> clazz) throws JsonMappingException, JsonProcessingException {
		return mapper.readValue(json,mapper.getTypeFactory().constructCollectionType(List.class, clazz));
	}

	@Override
	public <T> String listToStringJson(List<T> list) throws JsonProcessingException {
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
	}

}
