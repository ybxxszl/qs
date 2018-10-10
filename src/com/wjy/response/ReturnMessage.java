package com.wjy.response;

public class ReturnMessage {

	// 未知异常 UnknownException
	public final static String ERROR_500 = "UnknownException";

	// 空指针异常 NullPointerException
	public final static String ERROR_501 = "NullPointerException";

	// 下标越界异常 IndexOutOfBoundsException
	public final static String ERROR_502 = "IndexOutOfBoundsException";

	// 安全权限异常 IllegalAccessException
	public final static String ERROR_503 = "IllegalAccessException";

	// 角标异常 ArrayIndexOutOfBoundsException
	public final static String ERROR_504 = "ArrayIndexOutOfBoundsException";

	// 无法找到指定的类异常 ClassNotFoundException
	public final static String ERROR_505 = "ClassNotFoundException";

	// SQL异常
	public final static String ERROR_511 = "err101[SQL Exception]: 系统处理出错，请联系服务商处理！";
	public final static String ERROR_512 = "err102[No Connect Exception]: 系统处理出错，请联系服务商处理！";
	public final static String ERROR_513 = "err103[ParseJson Exception]: 系统处理出错，请联系服务商处理！";

	public final static String SUCCESS_200 = "SUCCESS";

}
