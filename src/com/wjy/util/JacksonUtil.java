package com.wjy.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	public static ObjectMapper getObjectMapper() {
		return mapper;
	}

	/**
	 * 将字符串转换成VO
	 *
	 * @param content
	 * @param valueType
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @author AMS-ZXH
	 */
	public static <T> T toVO(String content, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(content, valueType);
	}

	/**
	 * 将字符串转换成VO
	 *
	 * @param
	 * @param valueType
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @author AMS-ZXH
	 */
	public static <T> T toVO(JsonNode jsonNode, Class<T> valueType)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(jsonNode.toString(), valueType);
	}

	/**
	 * 将VO对象转换成字符串
	 *
	 * @param value
	 * @return
	 * @throws JsonProcessingException
	 * @author AMS-ZXH
	 */
	public static String toJsonString(Object value) throws JsonProcessingException {
		return mapper.writeValueAsString(value);

	}

	/**
	 * 获取对象节点，用于建立新的JSONObject
	 *
	 * @return
	 * @author AMS-ZXH
	 */
	public static ObjectNode getJsonObject() {
		JsonNodeFactory factory = JsonNodeFactory.instance;
		ObjectNode on = factory.objectNode();
		return on;
	}

	/**
	 * 获取json节点，可用于处理二级节点内容
	 *
	 * @param content
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @author AMS-ZXH
	 */
	public static JsonNode getJsonNode(String content) throws JsonProcessingException, IOException {
		return mapper.readValue(content, JsonNode.class);
	}

	/**
	 * 获取json节点，可用于处理二级节点内容
	 *
	 * @param content
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @author AMS-ZXH
	 */
	public static String getString(Object content) throws JsonProcessingException, IOException {
		return mapper.readValue(content.toString(), String.class);
	}

}
