package com.wjy.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @date 2019年1月8日
 * @author ybxxszl
 * @description 通用日志
 */
public abstract class LOGManage {

	// protected static Logger LOGGER = null;
	//
	// public LOGManage() {
	//
	// LOGGER = Logger.getLogger(this.getClass());
	//
	// }

	protected static Logger LOGGER = null;

	public LOGManage() {

		LOGGER = LogManager.getLogger(this.getClass());

	}

}
