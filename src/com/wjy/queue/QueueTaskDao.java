package com.wjy.queue;

import java.util.List;

import org.apache.log4j.Logger;

import com.wjy.jdbc.SQLUtil;

/**
 * @Date 2018/12/11
 * @Author ybxxszl
 * @Desc
 **/
public class QueueTaskDao extends SQLUtil {

	private static final Logger LOGGER = Logger.getLogger(QueueTaskDao.class);

	/**
	 * 新增队列任务
	 *
	 * @param queueTask
	 */
	public void insertQueueTask(QueueTask queueTask) throws Exception {

		LOGGER.info("新增队列任务: queueTask - " + queueTask.toString());

		String sql = "INSERT INTO queue_task(queue_id, queue_name, task_id, task_data, task_index, task_state) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";

		Object[] objects = new Object[] { queueTask.getQueue_id(), queueTask.getQueue_name(), queueTask.getTask_id(),
				queueTask.getTask_data(), queueTask.getTask_index(), queueTask.getTask_state() };

		Update(sql, objects);

	}

	/**
	 * 更新任务状态
	 *
	 * @param queueId
	 * @param taskState
	 */
	public void updateTaskStateByQueueId(String queueId, Integer taskState) throws Exception {

		LOGGER.info("更新任务状态: queueId - " + queueId + ", taskState - " + taskState);

		String sql = "UPDATE queue_task SET task_state = ? WHERE queue_id = ?";

		Object[] objects = new Object[] { taskState, queueId };

		Update(sql, objects);

	}

	/**
	 * 根据队列ID获取任务
	 *
	 * @param queueId
	 * @return
	 */
	public QueueTask selectQueueTaskByQueueId(String queueId) throws Exception {

		LOGGER.info("根据队列ID获取任务: queueId - " + queueId);

		String sql = "SELECT queue_id, queue_name, task_id, task_data, task_index, task_state "
				+ "FROM queue_task WHERE queue_id = ?";

		Object[] objects = new Object[] { queueId };

		List<QueueTask> queueTaskList = Query(sql, objects, QueueTask.class);

		if (queueTaskList.size() == 1) {
			return queueTaskList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 根据任务ID、执行顺序索引和状态获取任务
	 *
	 * @param taskId
	 * @param taskIndex
	 * @return
	 */
	public QueueTask selectQueueTaskByTaskIdANDTaskIndex(String taskId, Integer taskIndex, Integer taskState)
			throws Exception {

		LOGGER.info("根据任务ID、执行顺序索引和状态获取任务: taskId - " + taskId + ", taskIndex - " + taskIndex + ", taskState - "
				+ taskState);

		String sql = "SELECT queue_id, queue_name, task_id, task_data, task_index, task_state "
				+ "FROM queue_task WHERE task_id = ? AND task_index = ? AND task_state = ?";

		Object[] objects = new Object[] { taskId, taskIndex, taskState };

		List<QueueTask> queueTaskList = Query(sql, objects, QueueTask.class);

		if (queueTaskList.size() == 1) {
			return queueTaskList.get(0);
		} else {
			return null;
		}

	}

}
