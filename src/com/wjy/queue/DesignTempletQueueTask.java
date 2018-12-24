package com.wjy.queue;

import org.apache.log4j.Logger;

/**
 * @Date 2018/12/10
 * @Author ybxxszl
 * @Desc
 **/
public class DesignTempletQueueTask extends AbstractQueueTask {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletQueueTask.class);

	static {
		setThreadTask(new DesignTempletQueueTask());
	}

	@Override
	public String getQueueName() {
		return "DesignTempletQueueTask";
	}

	@Override
	public boolean executeTask(String data) {
		try {
			LOGGER.info("DesignTempletQueueTask - START");
			LOGGER.info(data);
			LOGGER.info("DesignTempletQueueTask - END");
		} catch (Exception e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		return true;
	}

}
