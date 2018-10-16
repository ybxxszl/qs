package com.wjy.test.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class SexJsonSerializer extends JsonSerializer<Integer> {

	@Override
	public void serialize(Integer state, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {

		String str = "女";

		if (state == 1) {

			str = "男";

		}

		jsonGenerator.writeString(str);

	}

}
