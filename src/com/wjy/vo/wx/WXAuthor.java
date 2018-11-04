package com.wjy.vo.wx;

public class WXAuthor {

	private String wx_author_id;
	private String wx_author_email;

	private String wx_author_nick_name;
	private String wx_author_sex;
	private String wx_author_country;
	private String wx_author_city;
	private String wx_author_province;
	private String wx_author_avatar_url;
	private String wx_author_open_id;

	public String getWx_author_id() {
		return wx_author_id;
	}

	public void setWx_author_id(String wx_author_id) {
		this.wx_author_id = wx_author_id;
	}

	public String getWx_author_email() {
		return wx_author_email;
	}

	public void setWx_author_email(String wx_author_email) {
		this.wx_author_email = wx_author_email;
	}

	public String getWx_author_nick_name() {
		return wx_author_nick_name;
	}

	public void setWx_author_nick_name(String wx_author_nick_name) {
		this.wx_author_nick_name = wx_author_nick_name;
	}

	public String getWx_author_sex() {
		return wx_author_sex;
	}

	public void setWx_author_sex(String wx_author_sex) {
		this.wx_author_sex = wx_author_sex;
	}

	public String getWx_author_country() {
		return wx_author_country;
	}

	public void setWx_author_country(String wx_author_country) {
		this.wx_author_country = wx_author_country;
	}

	public String getWx_author_city() {
		return wx_author_city;
	}

	public void setWx_author_city(String wx_author_city) {
		this.wx_author_city = wx_author_city;
	}

	public String getWx_author_province() {
		return wx_author_province;
	}

	public void setWx_author_province(String wx_author_province) {
		this.wx_author_province = wx_author_province;
	}

	public String getWx_author_avatar_url() {
		return wx_author_avatar_url;
	}

	public void setWx_author_avatar_url(String wx_author_avatar_url) {
		this.wx_author_avatar_url = wx_author_avatar_url;
	}

	public String getWx_author_open_id() {
		return wx_author_open_id;
	}

	public void setWx_author_open_id(String wx_author_open_id) {
		this.wx_author_open_id = wx_author_open_id;
	}

	public WXAuthor() {
		super();
	}

	public WXAuthor(String wx_author_id, String wx_author_email, String wx_author_nick_name, String wx_author_sex,
			String wx_author_country, String wx_author_city, String wx_author_province, String wx_author_avatar_url,
			String wx_author_open_id) {
		super();
		this.wx_author_id = wx_author_id;
		this.wx_author_email = wx_author_email;
		this.wx_author_nick_name = wx_author_nick_name;
		this.wx_author_sex = wx_author_sex;
		this.wx_author_country = wx_author_country;
		this.wx_author_city = wx_author_city;
		this.wx_author_province = wx_author_province;
		this.wx_author_avatar_url = wx_author_avatar_url;
		this.wx_author_open_id = wx_author_open_id;
	}

	@Override
	public String toString() {
		return "WXAuthor [wx_author_id=" + wx_author_id + ", wx_author_email=" + wx_author_email
				+ ", wx_author_nick_name=" + wx_author_nick_name + ", wx_author_sex=" + wx_author_sex
				+ ", wx_author_country=" + wx_author_country + ", wx_author_city=" + wx_author_city
				+ ", wx_author_province=" + wx_author_province + ", wx_author_avatar_url=" + wx_author_avatar_url
				+ ", wx_author_open_id=" + wx_author_open_id + "]";
	}

}
