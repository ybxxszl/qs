package com.wjy.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @date 2018年10月9日
 * @author ybxxszl
 * @description JDBC工具类
 */
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

	/**
	 * @date 2018年10月9日
	 * @author ybxxszl
	 * @description 打开JDBC连接
	 * @throws 数据库连接异常
	 * @return Connection 数据库连接
	 * @throws ClassNotFoundException
	 *             类找不到异常
	 * @throws SQLException
	 *             SQL异常
	 */
	public static Connection getConnect() throws ClassNotFoundException, SQLException {

		Class.forName(classname);

		conn = DriverManager.getConnection(url, user, password);

		return conn;

	}

}
