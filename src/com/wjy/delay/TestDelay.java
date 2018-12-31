package com.wjy.delay;

import com.wjy.util.JSONUtil;
import com.wjy.util.RandomCodeUtil;
import com.wjy.vo.DesignTemplet;

/**
 * @Date 2018/12/31
 * @Author ybxxszl
 * @Desc
 **/
public class TestDelay {

	@SuppressWarnings("unused")
	private DesignTempletDelayTask1 designTempletDelayTask1 = new DesignTempletDelayTask1();
	@SuppressWarnings("unused")
	private DesignTempletDelayTask2 designTempletDelayTask2 = new DesignTempletDelayTask2();

	private DelayTaskDao delayTaskDao = new DelayTaskDao();

	public void test() throws Exception {

		DesignTemplet designTemplet1 = new DesignTemplet();
		DesignTemplet designTemplet2 = new DesignTemplet();

		designTemplet1.setDesign_templet_id(RandomCodeUtil.getUUID());
		designTemplet1.setDesign_templet_name("1");

		designTemplet2.setDesign_templet_id(RandomCodeUtil.getUUID());
		designTemplet2.setDesign_templet_name("2");

		DelayTask delayTask1 = DesignTempletDelayTask1.packageDelayTask("DesignTempletDelayTask1", "1",
				JSONUtil.objectToJson(designTemplet1), DesignTempletDelayTask1.buildDelayTime(30), 1);
		DelayTask delayTask2 = DesignTempletDelayTask2.packageDelayTask("DesignTempletDelayTask2", "2",
				JSONUtil.objectToJson(designTemplet2), DesignTempletDelayTask1.buildDelayTime(60), 1);

		delayTaskDao.insertDelayTask(delayTask1);
		delayTaskDao.insertDelayTask(delayTask2);

		DesignTempletDelayTask1.pushDelayTask(delayTask1);
		DesignTempletDelayTask1.pushDelayTask(delayTask2);

	}

}
