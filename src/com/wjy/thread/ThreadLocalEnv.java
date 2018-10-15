package com.wjy.thread;

import org.apache.log4j.Logger;

import com.wjy.log.LOG;

/**
 * 定义线程环境
 * 
 * @date 2018年10月7日
 * @author ybxxszl
 * @description TODO
 */
public class ThreadLocalEnv {

	private static final Logger LOGGER = Logger.getLogger(ThreadLocalEnv.class);

	private static final ThreadLocal<ThreadLocalVar> ENV = new ThreadLocal<ThreadLocalVar>();

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

		ThreadLocalVar threadLocalVar = ENV.get();

		LOGGER.info("getENV：" + threadLocalVar.toString());

		LOG.pInfo("getENV：" + threadLocalVar.toString());

		return threadLocalVar;

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

		LOGGER.info("setENV：" + threadLocalVar.toString());

		LOG.pInfo("setENV：" + threadLocalVar.toString());

		ENV.set(threadLocalVar);

	}

}
