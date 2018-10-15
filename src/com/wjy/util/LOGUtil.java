package com.wjy.util;

import org.apache.log4j.Logger;

import com.wjy.log.LOG;

public abstract class LOGUtil {

	protected Logger LOGGER = null;

	protected LOG LOG = null;

	public LOGUtil() {

		super();

		LOGGER = Logger.getLogger(this.getClass());

		LOG = new LOG();

	}

}
