package com.wjy.bean.offical;

public class RegisterWXAuthor {

	private String wxAuthorEmail;
	private String verifyCode;
	private String encryptedData;
	private String iv;
	private String sessionKey;

	public String getWxAuthorEmail() {
		return wxAuthorEmail;
	}

	public void setWxAuthorEmail(String wxAuthorEmail) {
		this.wxAuthorEmail = wxAuthorEmail;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public RegisterWXAuthor() {
		super();
	}

	public RegisterWXAuthor(String wxAuthorEmail, String verifyCode, String encryptedData, String iv,
			String sessionKey) {
		super();
		this.wxAuthorEmail = wxAuthorEmail;
		this.verifyCode = verifyCode;
		this.encryptedData = encryptedData;
		this.iv = iv;
		this.sessionKey = sessionKey;
	}

	@Override
	public String toString() {
		return "RegisterWXAuthor [wxAuthorEmail=" + wxAuthorEmail + ", verifyCode=" + verifyCode + ", encryptedData="
				+ encryptedData + ", iv=" + iv + ", sessionKey=" + sessionKey + "]";
	}

}
