package com.wjy.test.jackson;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class User {

	@JsonProperty(value = "user_id")
	private String userId;

	private String name;

	private String account;

	@JsonIgnore
	private String password;

	@JsonInclude(value = Include.NON_NULL)
	private String desc;

	@JsonSerialize(using = SexJsonSerializer.class)
	@JsonDeserialize(using = SexJsonDeserializer.class)
	private Integer sex;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date birthday;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public User() {
		super();
	}

	public User(String userId, String name, String account, String password, String desc, Integer sex, Date birthday) {
		super();
		this.userId = userId;
		this.name = name;
		this.account = account;
		this.password = password;
		this.desc = desc;
		this.sex = sex;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", account=" + account + ", password=" + password
				+ ", desc=" + desc + ", sex=" + sex + ", birthday=" + birthday + "]";
	}

}
