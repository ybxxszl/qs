package com.wjy.queue;

import org.apache.log4j.Logger;

/**
 * @Date 2018/12/10
 * @Author ybxxszl
 * @Desc
 **/
public class DesignTempletQueueTask2 extends AbstractQueueTask {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletQueueTask2.class);

	static {
		setThreadTask(new DesignTempletQueueTask2());
	}

	@Override
	public String getQueueName() {
		return "DesignTempletQueueTask2";
	}

	@Override
	public boolean executeTask(String data) {
		try {
			LOGGER.info("DesignTempletQueueTask2 - START");
			LOGGER.info(data);
			LOGGER.info("DesignTempletQueueTask2 - END");
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		return true;
	}

}
