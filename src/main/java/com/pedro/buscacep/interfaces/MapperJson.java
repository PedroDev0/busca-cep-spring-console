package com.pedro.buscacep.interfaces;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface MapperJson {

	<T> T jsonToObject(String json, Class<T> clazz) throws JsonMappingException, JsonProcessingException;

	<T> List<T> jsonToList(String json, Class<T> clazz) throws JsonMappingException, JsonProcessingException;

	<T> T objectToJson(String json, Class<T> clazz) throws JsonMappingException, JsonProcessingException;

	<T> String listToStringJson(List<T> list) throws JsonProcessingException;

}
