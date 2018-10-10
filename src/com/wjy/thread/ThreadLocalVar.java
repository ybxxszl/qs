package com.wjy.thread;

import java.sql.Connection;
import java.sql.SQLException;

import com.wjy.mysql.JDBCUtil;

/**
 * 定义线程变量
 * 
 * @date 2018年10月7日
 * @author ybxxszl
 * @description TODO
 */
public class ThreadLocalVar {

	private String author_id;

	private String token;

	private Connection conn;

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @date 2018年10月9日
	 * @author ybxxszl
	 * @description 获取数据库连接
	 * @throws 数据库连接异常
	 * @return Connection 数据库连接
	 * @throws ClassNotFoundException
	 *             类找不到异常
	 * @throws SQLException
	 *             SQL异常
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException {
		// 初始化时创建数据库连接
		if (conn == null) {
			conn = JDBCUtil.getConnect();
			setConn(conn);
		}
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public ThreadLocalVar() {
		super();
	}

	public ThreadLocalVar(String author_id, String token) {
		super();
		this.author_id = author_id;
		this.token = token;
	}

	public ThreadLocalVar(Connection conn) {
		super();
		this.conn = conn;
	}

	public ThreadLocalVar(String author_id, String token, Connection conn) {
		super();
		this.author_id = author_id;
		this.token = token;
		this.conn = conn;
	}

	@Override
	public String toString() {
		return "ThreadLocalVar [author_id=" + author_id + ", token=" + token + ", conn=" + conn + "]";
	}

}
