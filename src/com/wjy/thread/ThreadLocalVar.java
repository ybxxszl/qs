package com.wjy.thread;

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

	public ThreadLocalVar() {
		super();
	}

	public ThreadLocalVar(String author_id, String author_name) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
	}

	@Override
	public String toString() {
		return "ThreadLocalVar [author_id=" + author_id + ", author_name=" + author_name + "]";
	}

}
