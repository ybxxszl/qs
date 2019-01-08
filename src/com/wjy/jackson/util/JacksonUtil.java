package com.wjy.jackson.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
	 * 将字符串转换成VO
	 * 
	 * @author AMS-ZXH
	 * @param content
	 * @param valueType
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T toVO(String content, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(content, valueType);
	}

	/**
	 * 将字符串转换成VO
	 * 
	 * @author AMS-ZXH
	 * @param content
	 * @param valueType
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T toVO(JsonNode jsonNode, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(jsonNode.toString(), valueType);
	}

	/**
	 * 将VO对象转换成字符串
	 * 
	 * @author AMS-ZXH
	 * @param value
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String toJsonString(Object value) throws JsonProcessingException {
		return mapper.writeValueAsString(value);

	}

	/**
	 * 获取对象节点，用于建立新的JSONObject
	 * 
	 * @author AMS-ZXH
	 * @return
	 */
	public static ObjectNode getJsonObject() {
		JsonNodeFactory factory = JsonNodeFactory.instance;
		ObjectNode on = factory.objectNode();
		return on;
	}

	/**
	 * 获取json节点，可用于处理二级节点内容
	 * 
	 * @author AMS-ZXH
	 * @param content
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static JsonNode getJsonNode(String content) throws JsonProcessingException, IOException {
		return mapper.readValue(content, JsonNode.class);
	}

	/**
	 * 获取json节点，可用于处理二级节点内容
	 * 
	 * @author AMS-ZXH
	 * @param content
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static String getString(Object content) throws JsonProcessingException, IOException {
		return mapper.readValue(content.toString(), String.class);
	}

}
