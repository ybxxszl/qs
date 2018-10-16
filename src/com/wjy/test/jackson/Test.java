package com.wjy.test.jackson;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Test {

	private static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws IOException {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", "wjy");
		map.put("age", 23);
		map.put("interests", new String[] { "lol", "music" });

		Info info = new Info("18743102774", "1062837400@qq.com");

		User user = new User("001", "王军岩", "wjy", "1234", null, 1, new Date());

		UserInfo userInfo = new UserInfo(user, info);

		test1(map);

		test2(userInfo);

	}

	private static void test1(Map<String, Object> map) throws IOException {

		String content = mapper.writeValueAsString(map);

		System.out.println(content);

		Map<String, Object> m = mapper.readValue(content, new TypeReference<Map<String, Object>>() {
		});

		System.out.println(m.toString());

		JsonNode root1 = mapper.readTree(content);

		Iterator<String> iterator1 = root1.fieldNames();

		while (iterator1.hasNext()) {

			String str = iterator1.next();

			System.out.println(str);

		}

		String name = root1.get("name").asText();
		int age = root1.get("age").asInt();
		JsonNode root2 = root1.get("interests");

		System.out.println(name);
		System.out.println(age);
		System.out.println(root2);

		Iterator<JsonNode> iterator2 = root2.elements();

		while (iterator2.hasNext()) {

			String str = iterator2.next().asText();

			System.out.println(str);

		}

		Iterator<Entry<String, JsonNode>> iterator3 = root1.fields();

		while (iterator3.hasNext()) {

			Entry<String, JsonNode> entry = iterator3.next();

			System.out.println(entry.getKey());
			System.out.println(entry.getValue());

		}

	}

	private static void test2(UserInfo userInfo) throws IOException {

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		String content = mapper.writeValueAsString(userInfo);

		System.out.println(content);

		UserInfo ui = mapper.readValue(content, UserInfo.class);

		System.out.println(ui.toString());

	}

}
