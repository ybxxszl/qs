package com.wjy.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	
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

	public static Connection getConnect() throws SQLException, ClassNotFoundException {

		Class.forName(classname);
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;

	}

}
