package com.wjy.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @date 2018年10月16日
 * @author ybxxszl
 * @description Jackson工具类
 */
public class JacksonUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	public static ObjectMapper getObjectMapper() {
		return mapper;
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
