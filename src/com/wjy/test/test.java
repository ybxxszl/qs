package com.wjy.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {

	private static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws IOException {

		Author author1 = new Author("author_account", "author_password");

		Author author2 = new Author("author_id", "author_account", "author_password", "author_name", "author_sex",
				"author_phone", "author_email", "author_photo");

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", "wjy");
		map.put("age", 23);
		map.put("interests", new String[] { "lol", "music" });

		test1(author1);

		test2(map);

	}

	private static void test2(Map<String, Object> map) throws IOException {

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

	private static void test1(Author author1) throws IOException {

		String content = mapper.writeValueAsString(author1);

		System.out.println(content);

		Author a = mapper.readValue(content, Author.class);

		System.out.println(a.toString());

	}

}
