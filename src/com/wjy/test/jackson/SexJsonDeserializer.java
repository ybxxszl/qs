package com.wjy.test.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SexJsonDeserializer extends JsonDeserializer<Integer> {

	@Override
	public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		String str = jsonParser.getValueAsString();

		Integer state = 0;

		if ("男".equals(str)) {

			state = 1;

		}

		return state;

	}

}
