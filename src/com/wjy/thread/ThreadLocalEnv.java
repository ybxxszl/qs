package com.wjy.thread;

/**
 * 定义线程环境
 * 
 * @date 2018年10月7日
 * @author ybxxszl
 * @description TODO
 */
public class ThreadLocalEnv {

	private static final ThreadLocalCustom ENV = new ThreadLocalCustom();

	/**
	 * GET当前环境变量
	 * 
	 * @date 2018年10月7日
	 * @author ybxxszl
	 * @description TODO
	 * @throws TODO
	 * @return ThreadLocalVar
	 */
	public static ThreadLocalVar getENV() {
		return ENV.get();
	}

	/**
	 * SET当前环境变量
	 * 
	 * @date 2018年10月7日
	 * @author ybxxszl
	 * @description TODO
	 * @throws TODO
	 * @param threadLocalVar
	 *            void
	 */
	public static void setENV(ThreadLocalVar threadLocalVar) {

		ENV.set(threadLocalVar);

	}

}
