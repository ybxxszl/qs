package com.wjy.queue;

import org.apache.log4j.Logger;

/**
 * @Date 2018/12/10
 * @Author ybxxszl
 * @Desc
 **/
public class DesignTempletQueueTask1 extends AbstractQueueTask {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletQueueTask1.class);

	static {
		setThreadTask(new DesignTempletQueueTask1());
	}

	@Override
	public String getQueueName() {
		return "DesignTempletQueueTask1";
	}

	@Override
	public boolean executeTask(String data) {
		try {
			LOGGER.info("DesignTempletQueueTask1 - START");
			LOGGER.info(data);
			LOGGER.info("DesignTempletQueueTask1 - END");
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		return true;
	}

}
