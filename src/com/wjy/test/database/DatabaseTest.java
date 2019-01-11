package com.wjy.test.database;

import org.springframework.mock.jndi.SimpleNamingContextBuilder;

public class DatabaseTest {

	private static DatabaseConfig config = new DatabaseConfig();

	private static SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();

	static {

		try {
			builder.bind("java:comp/env/etframework", config.getDataSource());
			builder.bind("java:comp/UserTransaction", config.getCurrent());
			builder.activate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
