package com.wjy.vo;

import java.util.Date;

public class Author {

	private String author_id;
	private String author_account;
	private String author_password;
	private String author_name;
	private String author_sex;
	private Date author_birthday;
	private String author_phone;
	private String author_email;
	private String author_photo;
	private Integer author_state;

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_account() {
		return author_account;
	}

	public void setAuthor_account(String author_account) {
		this.author_account = author_account;
	}

	public String getAuthor_password() {
		return author_password;
	}

	public void setAuthor_password(String author_password) {
		this.author_password = author_password;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getAuthor_sex() {
		return author_sex;
	}

	public void setAuthor_sex(String author_sex) {
		this.author_sex = author_sex;
	}

	public Date getAuthor_birthday() {
		return author_birthday;
	}

	public void setAuthor_birthday(Date author_birthday) {
		this.author_birthday = author_birthday;
	}

	public String getAuthor_phone() {
		return author_phone;
	}

	public void setAuthor_phone(String author_phone) {
		this.author_phone = author_phone;
	}

	public String getAuthor_email() {
		return author_email;
	}

	public void setAuthor_email(String author_email) {
		this.author_email = author_email;
	}

	public String getAuthor_photo() {
		return author_photo;
	}

	public void setAuthor_photo(String author_photo) {
		this.author_photo = author_photo;
	}

	public Integer getAuthor_state() {
		return author_state;
	}

	public void setAuthor_state(Integer author_state) {
		this.author_state = author_state;
	}

	public Author() {
		super();
	}

	public Author(String author_account) {
		super();
		this.author_account = author_account;
	}

	public Author(String author_account, String author_password) {
		super();
		this.author_account = author_account;
		this.author_password = author_password;
	}

	public Author(String author_id, String author_account, String author_password, String author_name,
			String author_sex, Date author_birthday, String author_phone, String author_email, String author_photo,
			Integer author_state) {
		super();
		this.author_id = author_id;
		this.author_account = author_account;
		this.author_password = author_password;
		this.author_name = author_name;
		this.author_sex = author_sex;
		this.author_birthday = author_birthday;
		this.author_phone = author_phone;
		this.author_email = author_email;
		this.author_photo = author_photo;
		this.author_state = author_state;
	}

	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", author_account=" + author_account + ", author_password="
				+ author_password + ", author_name=" + author_name + ", author_sex=" + author_sex + ", author_birthday="
				+ author_birthday + ", author_phone=" + author_phone + ", author_email=" + author_email
				+ ", author_photo=" + author_photo + ", author_state=" + author_state + "]";
	}

}
