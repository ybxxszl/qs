package com.wjy.response;

import com.wjy.exception.business.BusinessException;
import com.wjy.exception.system.SystemException;

public class ReturnBuilder {

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

	public ReturnBuilder() {
		super();
	}

	public ReturnBuilder(Integer code, Object data, String msg) {
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
	public static ReturnBuilder build(Integer code, Object data, String msg) {

		return new ReturnBuilder(code, data, msg);

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 成功返回数据
	 * @param data
	 * @return Return
	 */
	public static ReturnBuilder successData(Object data) {

		return new ReturnBuilder(200, data, null);

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 成功返回信息
	 * @param msg
	 * @return Return
	 */
	public static ReturnBuilder successMsg(String msg) {

		return new ReturnBuilder(200, null, msg);

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 成功返回数据和信息
	 * @param data
	 * @param msg
	 * @return Return
	 */
	public static ReturnBuilder successDataAndMsg(Object data, String msg) {

		return new ReturnBuilder(200, data, msg);

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 失败系统异常
	 * @param exception
	 * @return Return
	 */
	public static ReturnBuilder errorSystemException(SystemException exception) {

		return new ReturnBuilder(900, null, exception.getMessage());

	}

	/**
	 * @date 2018年10月21日
	 * @author ybxxszl
	 * @description 失败业务异常
	 * @param exception
	 * @return Return
	 */
	public static ReturnBuilder errorBusinessException(BusinessException exception) {

		return new ReturnBuilder(700, null, exception.getMessage());

	}

}
