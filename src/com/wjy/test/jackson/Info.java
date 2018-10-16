package com.wjy.test.jackson;

public class Info {

	private String phone;

	private String email;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Info() {
		super();
	}

	public Info(String phone, String email) {
		super();
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Info [phone=" + phone + ", email=" + email + "]";
	}

}
