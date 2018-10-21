package com.wjy.response;

import com.wjy.exception.BusinessException;

public class Return {

	// 状态码
	private Integer code;

	// 数据
	private Object data;

	// 消息
	private String msg;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Return() {
		super();
	}

	public Return(Integer code, Object data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Return [code=" + code + ", data=" + data + ", msg=" + msg + "]";
	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 建立自定义返回
	 * @param code
	 * @param data
	 * @param msg
	 * @return Return
	 */
	public static Return build(Integer code, Object data, String msg) {

		return new Return(code, data, msg);

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 成功返回数据
	 * @param data
	 * @return Return
	 */
	public static Return successData(Object data) {

		return new Return(200, data, null);

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 成功返回信息
	 * @param msg
	 * @return Return
	 */
	public static Return successMsg(String msg) {

		return new Return(200, null, msg);

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 成功返回数据和信息
	 * @param data
	 * @param msg
	 * @return Return
	 */
	public static Return successDataAndMsg(Object data, String msg) {

		return new Return(200, data, msg);

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 失败业务异常
	 * @param exception
	 * @return Return
	 */
	public static Return errorBusinessException(BusinessException exception) {

		return new Return(500, null, exception.getMessage());

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 失败系统异常
	 * @param exception
	 * @return Return
	 */
	public static Return errorSystemException(Exception exception) {

		return new Return(600, null, exception.getMessage());

	}

}
