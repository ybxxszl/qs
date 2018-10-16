package com.wjy.test.jackson;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class UserInfo {

	@JsonUnwrapped
	private User user;

	@JsonUnwrapped
	private Info info;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(User user, Info info) {
		super();
		this.user = user;
		this.info = info;
	}

	@Override
	public String toString() {
		return "UserInfo [user=" + user + ", info=" + info + "]";
	}

}
