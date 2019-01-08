package com.wjy.jackson.serializer;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(value.toString());
	}

	@Override
	public Class<Date> handledType() {
		return Date.class;
	}

}
