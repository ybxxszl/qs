package com.wjy.exception;

/**
 * @author ybxxszl
 * @date 2018年9月9日
 * @description 系统异常
 */
public class SystemException extends Exception {

	private static final long serialVersionUID = -788864009346944626L;

	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
	}

}
