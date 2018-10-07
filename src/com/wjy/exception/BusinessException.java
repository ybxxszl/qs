package com.wjy.exception;

/**
 * @author ybxxszl
 * @date 2018年9月9日
 * @description 业务异常
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = -7146898447624229711L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

}
