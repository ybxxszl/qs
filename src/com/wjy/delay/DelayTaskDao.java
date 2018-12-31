package com.wjy.delay;

import java.util.List;

import org.apache.log4j.Logger;

import com.wjy.jdbc.SQLUtil;

public class DelayTaskDao extends SQLUtil {

	private static final Logger LOGGER = Logger.getLogger(DelayTaskDao.class);

	/**
	 * 新增延时任务
	 *
	 * @param delayTask
	 */
	public void insertDelayTask(DelayTask delayTask) throws Exception {

		LOGGER.info("新增延时任务: delayTask - " + delayTask.toString());

		String sql = "INSERT INTO delay_task(delay_id, delay_name, task_id, task_data, task_score, task_state) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";

		Object[] objects = new Object[] { delayTask.getDelay_id(), delayTask.getDelay_name(), delayTask.getTask_id(),
				delayTask.getTask_data(), delayTask.getTask_score(), delayTask.getTask_state() };

		Update(sql, objects);

	}

	/**
	 * 更新任务状态
	 *
	 * @param delayId
	 * @param taskState
	 * @throws Exception
	 */
	public void updateTaskStateByDelayId(String delayId, int taskState) throws Exception {

		LOGGER.info("更新任务状态: delayId - " + delayId + ", taskState - " + taskState);

		String sql = "UPDATE delay_task SET task_state = ? WHERE delay_id = ?";

		Object[] objects = new Object[] { taskState, delayId };

		Update(sql, objects);

	}

	/**
	 * 根据队列ID获取任务
	 *
	 * @param delayId
	 * @return
	 * @throws Exception
	 */
	public DelayTask selectDelayTaskByDelayId(String delayId) throws Exception {

		LOGGER.info("根据队列ID获取任务: delayId - " + delayId);

		String sql = "SELECT delay_id, delay_name, task_id, task_data, task_score, task_state "
				+ "FROM delay_task WHERE delay_id = ?";

		Object[] objects = new Object[] { delayId };

		List<DelayTask> delayTaskList = Query(sql, objects, DelayTask.class);

		if (delayTaskList.size() == 1) {
			return delayTaskList.get(0);
		} else {
			return null;
		}

	}

}
