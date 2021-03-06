package com.wjy.jackson.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomLongSerializer extends JsonSerializer<Long> {

	@Override
	public void serialize(Long value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(value.toString());
	}

	@Override
	public Class<Long> handledType() {
		return Long.class;
	}

}
