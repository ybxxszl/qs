package com.wjy.log;

import org.apache.log4j.Logger;

import com.wjy.log.LOG;

/**
 * @date 2018年10月16日
 * @author ybxxszl
 * @description 通用日志
 */
public abstract class GeneralLOG {

	protected static Logger LOGGER = null;

	protected static LOG LOG = null;

	public GeneralLOG() {

		super();

		LOGGER = Logger.getLogger(this.getClass());

		LOG = new LOG();

	}

}
