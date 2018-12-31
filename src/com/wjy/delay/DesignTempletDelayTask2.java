package com.wjy.delay;

import org.apache.log4j.Logger;

/**
 * @Date 2018/12/31
 * @Author ybxxszl
 * @Desc
 **/
public class DesignTempletDelayTask2 extends AbstractDelayTask {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletDelayTask2.class);

	static {
		setThreadTask(new DesignTempletDelayTask2());
	}

	@Override
	public String getDelayName() {
		return "DesignTempletDelayTask2";
	}

	@Override
	public boolean executeTask(String data) {
		try {
			LOGGER.info("DesignTempletDelayTask2 - START");
			LOGGER.info(data);
			LOGGER.info("DesignTempletDelayTask2 - END");
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		return true;
	}

}
