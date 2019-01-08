package com.wjy.jackson.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.wjy.jackson.serializer.CustomBooleanSerializer;
import com.wjy.jackson.serializer.CustomCharacterSerializer;
import com.wjy.jackson.serializer.CustomDateSerializer;
import com.wjy.jackson.serializer.CustomDoubleSerializer;
import com.wjy.jackson.serializer.CustomIntegerSerializer;
import com.wjy.jackson.serializer.CustomLongSerializer;
import com.wjy.jackson.serializer.CustomShortSerializer;
import com.wjy.jackson.serializer.CustomStringSerializer;
import com.wjy.jackson.vo.SuperVOModule;

public class JacksonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	public static ObjectMapper getObjectMapper() {
		return mapper;
	}

	static {
		initConfig(mapper);
	}

	public static void initConfig(ObjectMapper mapper) {
		SimpleModule module = new SimpleModule("SerializerModule");
		module.addSerializer(new CustomBooleanSerializer());
		module.addSerializer(new CustomCharacterSerializer());
		module.addSerializer(new CustomDateSerializer());
		module.addSerializer(new CustomDoubleSerializer());
		module.addSerializer(new CustomIntegerSerializer());
		module.addSerializer(new CustomLongSerializer());
		module.addSerializer(new CustomShortSerializer());
		module.addSerializer(new CustomStringSerializer());
		mapper.registerModule(module);
		mapper.registerModule(new SuperVOModule());

	}

	/**
	 * 将String转换成VO
	 */
	public static <T> T toVO(String content, Class<T> valueType) throws IOException {
		return mapper.readValue(content, valueType);
	}

	/**
	 * 将JsonNode转换成VO
	 */
	public static <T> T toVO(JsonNode jsonNode, Class<T> valueType) throws IOException {
		return mapper.readValue(jsonNode.toString(), valueType);
	}

	/**
	 * 将Object转换成String
	 */
	public static String toString(Object value) throws IOException {
		return mapper.writeValueAsString(value);

	}

	/**
	 * 将Object转换成JsonNode
	 */
	public static JsonNode getJsonNode(Object value) throws IOException {
		return mapper.readValue(value.toString(), JsonNode.class);
	}

}
