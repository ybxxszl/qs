package com.wjy.bean.offical;

public class UserInfo {

	private String nickName;
	private Integer gender;
	private String country;
	private String city;
	private String province;
	private String avatarUrl;
	private String openId;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(String nickName, Integer gender, String country, String city, String province, String avatarUrl,
			String openId) {
		super();
		this.nickName = nickName;
		this.gender = gender;
		this.country = country;
		this.city = city;
		this.province = province;
		this.avatarUrl = avatarUrl;
		this.openId = openId;
	}

	@Override
	public String toString() {
		return "UserInfo [nickName=" + nickName + ", gender=" + gender + ", country=" + country + ", city=" + city
				+ ", province=" + province + ", avatarUrl=" + avatarUrl + ", openId=" + openId + "]";
	}

}
