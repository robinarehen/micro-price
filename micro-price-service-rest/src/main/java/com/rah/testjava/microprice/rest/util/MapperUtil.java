package com.rah.testjava.microprice.rest.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rah.testjava.microprice.rest.entity.PriceEntity;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MapperUtil {

	private ObjectMapper objectMapper;

	public MapperUtil() {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		this.objectMapper.registerModule(new JavaTimeModule()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
				false);
		this.objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	}

	public <T> T mapperObject(Object input, Class<T> output) {
		return this.objectMapper.convertValue(input, output);
	}

	public String mapperToJson(Object input) {
		try {
			return this.objectMapper.writeValueAsString(input);
		} catch (JsonProcessingException exception) {
			log.error("error message: {}", exception.getMessage(), exception);
			return null;
		}
	}

	public List<PriceEntity> mapperJsonToObject(String inputJson) {
		try {
			return this.objectMapper.readValue(inputJson, new TypeReference<List<PriceEntity>>() {
			});
		} catch (JsonProcessingException exception) {
			log.error("error message: {}", exception.getMessage(), exception);
			return null;
		}
	}
}
