package com.wjy.jackson.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomShortSerializer extends JsonSerializer<Short> {

	@Override
	public void serialize(Short value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(value.toString());
	}

	@Override
	public Class<Short> handledType() {
		return Short.class;
	}

}
