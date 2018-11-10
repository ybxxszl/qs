package com.wjy.log;

import org.apache.log4j.Logger;

/**
 * @date 2018年10月16日
 * @author ybxxszl
 * @description 通用日志
 */
public abstract class LOGManage {

	protected static Logger LOGGER = null;

	public LOGManage() {

		super();

		LOGGER = Logger.getLogger(this.getClass());

	}

}
