package com.wjy.delay;

import org.apache.log4j.Logger;

/**
 * @Date 2018/12/31
 * @Author ybxxszl
 * @Desc
 **/
public class DesignTempletDelayTask1 extends AbstractDelayTask {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletDelayTask1.class);

	static {
		setThreadTask(new DesignTempletDelayTask1());
	}

	@Override
	public String getDelayName() {
		return "DesignTempletDelayTask1";
	}

	@Override
	public boolean executeTask(String data) {
		try {
			LOGGER.info("DesignTempletDelayTask1 - START");
			LOGGER.info(data);
			LOGGER.info("DesignTempletDelayTask1 - END");
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		return true;
	}

}
