package com.wjy.queue;

import com.wjy.util.JSONUtil;
import com.wjy.util.RandomCodeUtil;
import com.wjy.vo.DesignTemplet;

/**
 * @Date 2018/12/15
 * @Author ybxxszl
 * @Desc
 **/
public class TestQueue {

	private QueueTaskDao queueTaskDao = new QueueTaskDao();

	private DesignTempletQueueTask1 designTempletQueueTask1 = new DesignTempletQueueTask1();
	private DesignTempletQueueTask2 designTempletQueueTask2 = new DesignTempletQueueTask2();
	private DesignTempletQueueTask3 designTempletQueueTask3 = new DesignTempletQueueTask3();

	public void test() throws Exception {

		DesignTemplet designTemplet1 = new DesignTemplet();
		DesignTemplet designTemplet2 = new DesignTemplet();
		DesignTemplet designTemplet3 = new DesignTemplet();

		designTemplet1.setDesign_templet_id(RandomCodeUtil.getUUID());
		designTemplet1.setDesign_templet_name("1");

		designTemplet2.setDesign_templet_id(RandomCodeUtil.getUUID());
		designTemplet2.setDesign_templet_name("2");

		designTemplet3.setDesign_templet_id(RandomCodeUtil.getUUID());
		designTemplet3.setDesign_templet_name("3");

		QueueTask queueTask1 = designTempletQueueTask1.packageQueueTask("DesignTempletQueueTask1", "0",
				JSONUtil.objectToJson(designTemplet1), 1, 1);
		QueueTask queueTask2 = designTempletQueueTask2.packageQueueTask("DesignTempletQueueTask2", "0",
				JSONUtil.objectToJson(designTemplet2), 2, 1);
		QueueTask queueTask3 = designTempletQueueTask3.packageQueueTask("DesignTempletQueueTask3", "0",
				JSONUtil.objectToJson(designTemplet3), 3, 1);

		queueTaskDao.insertQueueTask(queueTask1);
		queueTaskDao.insertQueueTask(queueTask2);
		queueTaskDao.insertQueueTask(queueTask3);

		AbstractQueueTask.pushQueueTask(queueTask1);

	}

}
