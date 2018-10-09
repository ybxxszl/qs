package com.wjy.thread;

import java.sql.Connection;

/**
 * 定义线程变量
 * 
 * @date 2018年10月7日
 * @author ybxxszl
 * @description TODO
 */
public class ThreadLocalVar {

	private String author_id;
	private String author_name;

	private Connection conn;

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public ThreadLocalVar() {
		super();
	}

	public ThreadLocalVar(Connection conn) {
		super();
		this.conn = conn;
	}

	public ThreadLocalVar(String author_id, String author_name, Connection conn) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
		this.conn = conn;
	}

	@Override
	public String toString() {
		return "ThreadLocalVar [author_id=" + author_id + ", author_name=" + author_name + ", conn=" + conn + "]";
	}

}
