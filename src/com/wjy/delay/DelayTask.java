package com.wjy.delay;

public class DelayTask {

	private String delay_id;
	private String delay_name;
	private String task_id;
	private String task_data;
	private Double task_score;
	private Integer task_state; // 1 等待中 2 执行中 3 已完成 4 已取消

	public String getDelay_id() {
		return delay_id;
	}

	public void setDelay_id(String delay_id) {
		this.delay_id = delay_id;
	}

	public String getDelay_name() {
		return delay_name;
	}

	public void setDelay_name(String delay_name) {
		this.delay_name = delay_name;
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

	public Double getTask_score() {
		return task_score;
	}

	public void setTask_score(Double task_score) {
		this.task_score = task_score;
	}

	public Integer getTask_state() {
		return task_state;
	}

	public void setTask_state(Integer task_state) {
		this.task_state = task_state;
	}

	public DelayTask() {
		super();
	}

	public DelayTask(String delay_id, String delay_name, String task_id, String task_data, Double task_score,
			Integer task_state) {
		super();
		this.delay_id = delay_id;
		this.delay_name = delay_name;
		this.task_id = task_id;
		this.task_data = task_data;
		this.task_score = task_score;
		this.task_state = task_state;
	}

	@Override
	public String toString() {
		return "DelayTask [delay_id=" + delay_id + ", delay_name=" + delay_name + ", task_id=" + task_id
				+ ", task_data=" + task_data + ", task_score=" + task_score + ", task_state=" + task_state + "]";
	}

}
