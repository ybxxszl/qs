package com.wjy.delay;

import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.wjy.jedis.RedisUtil;
import com.wjy.util.RandomCodeUtil;

import redis.clients.jedis.Tuple;

/**
 * @Date 2018/12/26
 * @Author ybxxszl
 * @Desc
 **/
public abstract class AbstractDelayTask {

	private static final Logger LOGGER = Logger.getLogger(AbstractDelayTask.class);

	private DelayTaskDao delayTaskDao = new DelayTaskDao();

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
	 * @param delayTask
	 */
	public static void setThreadTask(AbstractDelayTask delayTask) {
		new Thread() {
			@Override
			public void run() {
				LOGGER.info("设置线程任务: delayTask - " + delayTask.toString());
				AbstractDelayTask.popdelayTask(delayTask);
			}
		}.start();
	}

	/**
	 * 弹出延时任务
	 *
	 * @param delayTask
	 */
	public static void popdelayTask(AbstractDelayTask delayTask) {
		try {
			while (true) {
				Set<Tuple> set = RedisUtil.zrangeWithScores(delayTask.getDelayName(), 0, 0);
				if (set.isEmpty()) {
					TimeUnit.SECONDS.sleep(10);
				} else {
					Object[] objects = set.toArray();
					Tuple tuple = (Tuple) objects[0];
					Double score = tuple.getScore();
					String member = tuple.getElement();
					// LOGGER.info("弹出延时任务: score - " + score + ", member - " + member);
					if (buildDelayTime(0).compareTo(score) >= 1) {
						RedisUtil.zrem(delayTask.getDelayName(), member);
						getThread(delayTask, member);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("弹出延时任务", e);
			e.printStackTrace();
		}
	}

	/**
	 * 获取线程
	 *
	 * @param delayTask
	 * @param delayId
	 */
	public static void getThread(AbstractDelayTask delayTask, String delayId) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				LOGGER.info("获取线程: delayTask - " + delayTask.toString() + ", delayId - " + delayId);
				delayTask.executeDelayTask(delayId);
			}
		});
	}

	/**
	 * 推送延时任务
	 *
	 * @param task
	 */
	public static void pushDelayTask(DelayTask task) {
		LOGGER.info("推送延时任务: task - " + task.toString());
		RedisUtil.zadd(task.getDelay_name(), task.getTask_score(), task.getDelay_id());
	}

	/**
	 * 获取并执行任务
	 *
	 * @param delayId
	 */
	public void executeDelayTask(String delayId) {
		LOGGER.info("获取并执行任务: delayId - " + delayId);
		try {
			// 1、获取任务
			DelayTask delayTask = delayTaskDao.selectDelayTaskByDelayId(delayId);
			String taskData = delayTask.getTask_data();
			Integer taskState = delayTask.getTask_state();
			// 2、修改状态
			delayTaskDao.updateTaskStateByDelayId(delayId, taskState + 1);
			// 3、执行任务
			executeTask(taskData);
			// 4、修改状态
			delayTaskDao.updateTaskStateByDelayId(delayId, taskState + 2);
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
	 * 获取延时名称
	 *
	 * @return
	 */
	public abstract String getDelayName();

	/**
	 * 包装延时任务
	 *
	 * @param delayName
	 * @param taskId
	 * @param taskData
	 * @param taskScore
	 * @param taskState
	 * @return
	 */
	public static DelayTask packageDelayTask(String delayName, String taskId, String taskData, Double taskScore,
			Integer taskState) {
		DelayTask delayTask = new DelayTask();
		delayTask.setDelay_id(RandomCodeUtil.getUUID());
		delayTask.setDelay_name(delayName);
		delayTask.setTask_id(taskId);
		delayTask.setTask_data(taskData);
		delayTask.setTask_score(taskScore);
		delayTask.setTask_state(taskState);
		return delayTask;
	}

	/**
	 * 建立延时时间
	 *
	 * @param amount
	 * @return
	 */
	public static Double buildDelayTime(int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, amount);
		Double currentTime = (double) calendar.getTimeInMillis();
		LOGGER.info("建立延时时间: currentTime - " + currentTime);
		return currentTime;
	}

}
