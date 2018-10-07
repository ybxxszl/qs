package com.wjy.vo;

public class SingleAnswerCount {

	private String single_answer_count_id;
	private Integer single_answer_count;
	private String design_single_option_id;

	public String getSingle_answer_count_id() {
		return single_answer_count_id;
	}

	public void setSingle_answer_count_id(String single_answer_count_id) {
		this.single_answer_count_id = single_answer_count_id;
	}

	public Integer getSingle_answer_count() {
		return single_answer_count;
	}

	public void setSingle_answer_count(Integer single_answer_count) {
		this.single_answer_count = single_answer_count;
	}

	public String getDesign_single_option_id() {
		return design_single_option_id;
	}

	public void setDesign_single_option_id(String design_single_option_id) {
		this.design_single_option_id = design_single_option_id;
	}

	public SingleAnswerCount() {
		super();
	}

	public SingleAnswerCount(String single_answer_count_id, Integer single_answer_count,
			String design_single_option_id) {
		super();
		this.single_answer_count_id = single_answer_count_id;
		this.single_answer_count = single_answer_count;
		this.design_single_option_id = design_single_option_id;
	}

	@Override
	public String toString() {
		return "SingleAnswerCount [single_answer_count_id=" + single_answer_count_id + ", single_answer_count="
				+ single_answer_count + ", design_single_option_id=" + design_single_option_id + "]";
	}

}
