package com.wjy.jackson.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomStringSerializer extends JsonSerializer<String> {

	@Override
	public void serialize(String value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(value.toString());
	}

	@Override
	public Class<String> handledType() {
		return String.class;
	}

}
