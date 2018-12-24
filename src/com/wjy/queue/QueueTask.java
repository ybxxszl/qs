package com.wjy.queue;

public class QueueTask {

	private String queue_id;
	private String queue_name;
	private String task_id;
	private String task_data;
	private Integer task_index;
	private Integer task_state; // 1 等待中 2 执行中 3 已完成 4 已取消

	public String getQueue_id() {
		return queue_id;
	}

	public void setQueue_id(String queue_id) {
		this.queue_id = queue_id;
	}

	public String getQueue_name() {
		return queue_name;
	}

	public void setQueue_name(String queue_name) {
		this.queue_name = queue_name;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getTask_data() {
		return task_data;
	}

	public void setTask_data(String task_data) {
		this.task_data = task_data;
	}

	public Integer getTask_index() {
		return task_index;
	}

	public void setTask_index(Integer task_index) {
		this.task_index = task_index;
	}

	public Integer getTask_state() {
		return task_state;
	}

	public void setTask_state(Integer task_state) {
		this.task_state = task_state;
	}

	public QueueTask() {
		super();
	}

	public QueueTask(String queue_id, String queue_name, String task_id, String task_data, Integer task_index,
			Integer task_state) {
		super();
		this.queue_id = queue_id;
		this.queue_name = queue_name;
		this.task_id = task_id;
		this.task_data = task_data;
		this.task_index = task_index;
		this.task_state = task_state;
	}

	@Override
	public String toString() {
		return "QueueTask [queue_id=" + queue_id + ", queue_name=" + queue_name + ", task_id=" + task_id
				+ ", task_data=" + task_data + ", task_index=" + task_index + ", task_state=" + task_state + "]";
	}

}
