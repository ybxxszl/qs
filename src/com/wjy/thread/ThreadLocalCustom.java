package com.wjy.thread;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wjy.util.PropertiesUtil;

public class ThreadLocalCustom extends ThreadLocal<ThreadLocalVar> {

	private static String classname;
	private static String url;
	private static String user;
	private static String password;

	public static ResultSet rs = null;
	public static PreparedStatement pstmt = null;
	public static CallableStatement cstmt = null;
	public static Connection conn = null;

	static {

		classname = PropertiesUtil.getValue("mysql.classname");
		url = PropertiesUtil.getValue("mysql.url");
		user = PropertiesUtil.getValue("mysql.user");
		password = PropertiesUtil.getValue("mysql.password");

	}

	public static void getConnect() throws SQLException, ClassNotFoundException {

		Class.forName(classname);
		conn = DriverManager.getConnection(url, user, password);

	}

	public static void getClose() throws SQLException {

		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (cstmt != null) {
			cstmt.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	@Override
	protected ThreadLocalVar initialValue() {

		try {

			Class.forName(classname);
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ThreadLocalVar threadLocalVar = new ThreadLocalVar(conn);

		return threadLocalVar;

	}

}
