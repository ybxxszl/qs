package com.wjy.queue;

import org.apache.log4j.Logger;

/**
 * @Date 2018/12/10
 * @Author ybxxszl
 * @Desc
 **/
public class DesignTempletQueueTask3 extends AbstractQueueTask {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletQueueTask3.class);

	static {
		setThreadTask(new DesignTempletQueueTask3());
	}

	@Override
	public String getQueueName() {
		return "DesignTempletQueueTask3";
	}

	@Override
	public boolean executeTask(String data) {
		try {
			LOGGER.info("DesignTempletQueueTask3 - START");
			LOGGER.info(data);
			LOGGER.info("DesignTempletQueueTask3 - END");
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		return true;
	}

}
