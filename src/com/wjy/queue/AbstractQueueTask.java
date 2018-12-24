package com.wjy.queue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.wjy.jedis.RedisUtil;
import com.wjy.util.RandomCodeUtil;

/**
 * @Date 2018/12/6
 * @Author ybxxszl
 * @Desc
 **/
public abstract class AbstractQueueTask {

	private static final Logger LOGGER = Logger.getLogger(AbstractQueueTask.class);

	private QueueTaskDao queueTaskDao = new QueueTaskDao();

	private static final int COREPOOLSIZE = 10; // 核心线程数
	private static final int MAXIMUMPOOLSIZE = 20; // 线程池最大线程数
	private static final long KEEPALIVETIME = 5; // 非核心线程闲置超时时间

	/**
	 * 设置线程池
	 */
	static ThreadPoolExecutor executor = new ThreadPoolExecutor(COREPOOLSIZE, MAXIMUMPOOLSIZE, KEEPALIVETIME,
			TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

	/**
	 * 设置线程任务
	 *
	 * @param queueTask
	 */
	public static void setThreadTask(AbstractQueueTask queueTask) {
		new Thread() {
			@Override
			public void run() {
				LOGGER.info("设置线程任务: queueTask - " + queueTask.toString());
				AbstractQueueTask.popQueueTask(queueTask);
			}
		}.start();
	}

	/**
	 * 弹出队列任务
	 *
	 * @param queueTask
	 */
	public static void popQueueTask(AbstractQueueTask queueTask) {
		try {
			while (true) {
				List<String> list = RedisUtil.brpop(0, queueTask.getQueueName());
				String queueId = list.get(1);
				AbstractQueueTask.getThread(queueTask, queueId);
			}
		} catch (Exception e) {
			LOGGER.error("弹出队列任务", e);
			e.printStackTrace();
		}
	}

	/**
	 * 获取线程
	 *
	 * @param queueTask
	 * @param queueId
	 */
	public static void getThread(AbstractQueueTask queueTask, String queueId) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				LOGGER.info("获取线程: queueTask - " + queueTask.toString() + ", queueId - " + queueId);
				queueTask.executeQueueTask(queueId);
			}
		});
	}

	/**
	 * 推送队列任务
	 *
	 * @param task
	 */
	public static void pushQueueTask(QueueTask task) {
		LOGGER.info("推送队列任务: task - " + task.toString());
		RedisUtil.lpush(task.getQueue_name(), task.getQueue_id());
	}

	/**
	 * 获取并执行任务
	 *
	 * @param queueId
	 */
	public void executeQueueTask(String queueId) {
		LOGGER.info("获取并执行任务: queueId - " + queueId);
		try {
			// 1、获取任务
			QueueTask queueTask = queueTaskDao.selectQueueTaskByQueueId(queueId);
			String taskId = queueTask.getTask_id();
			String taskData = queueTask.getTask_data();
			Integer taskIndex = queueTask.getTask_index();
			Integer taskState = queueTask.getTask_state();
			// 2、修改状态
			queueTaskDao.updateTaskStateByQueueId(queueId, taskState + 1);
			// 3、执行任务
			boolean flag = executeTask(taskData);
			// 4、修改状态
			queueTaskDao.updateTaskStateByQueueId(queueId, taskState + 2);
			if (flag) {
				// 5、更新任务
				QueueTask task = queueTaskDao.selectQueueTaskByTaskIdANDTaskIndex(taskId, taskIndex + 1, 1);
				if (task != null) {
					pushQueueTask(task);
				}
			}
		} catch (Exception e) {
			LOGGER.error("获取并执行任务", e);
			e.printStackTrace();
		}
	}

	/**
	 * 执行任务
	 *
	 * @param data
	 * @return
	 */
	public abstract boolean executeTask(String data);

	/**
	 * 获取队列名称
	 *
	 * @return
	 */
	public abstract String getQueueName();

	/**
	 * 包装队列任务
	 *
	 * @param queueName
	 * @param taskId
	 * @param taskData
	 * @param taskIndex
	 * @param taskState
	 * @return
	 */
	public QueueTask packageQueueTask(String queueName, String taskId, String taskData, Integer taskIndex,
			Integer taskState) {
		QueueTask queueTask = new QueueTask();
		queueTask.setQueue_id(RandomCodeUtil.getUUID());
		queueTask.setQueue_name(queueName);
		queueTask.setTask_id(taskId);
		queueTask.setTask_data(taskData);
		queueTask.setTask_index(taskIndex);
		queueTask.setTask_state(taskState);
		return queueTask;
	}

}
