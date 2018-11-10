package com.wjy.param;

/*
 * 业务参数
 */
public enum BusinessParam {

	BusinessParam_1("1", "1", "业务参数1", "1", "1", "1"), BusinessParam_2("2", "2", "业务参数2", "2", "2", "2");

	// 参数ID
	private String id;

	// 参数编码
	private String code;

	// 参数名称
	private String name;

	// 参数初始
	private String init;

	// 参数类型
	private String type;

	// 参数备注
	private String remark;

	/*
	 * 根据编码获取参数
	 */
	public static BusinessParam getBusinessParam(String code) {

		for (BusinessParam param : BusinessParam.values()) {

			if (param.code.equals(code)) {

				return param;

			}

		}

		return null;

	}

	private BusinessParam() {

	}

	private BusinessParam(String id, String code, String name, String init, String type, String remark) {

		this.id = id;
		this.code = code;
		this.name = name;
		this.init = init;
		this.type = type;
		this.remark = remark;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
