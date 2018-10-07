package com.wjy.vo;

public class CheckboxAnswerCount {

	private String checkbox_answer_count_id;
	private Integer checkbox_answer_count;
	private String design_checkbox_option_id;

	public String getCheckbox_answer_count_id() {
		return checkbox_answer_count_id;
	}

	public void setCheckbox_answer_count_id(String checkbox_answer_count_id) {
		this.checkbox_answer_count_id = checkbox_answer_count_id;
	}

	public Integer getCheckbox_answer_count() {
		return checkbox_answer_count;
	}

	public void setCheckbox_answer_count(Integer checkbox_answer_count) {
		this.checkbox_answer_count = checkbox_answer_count;
	}

	public String getDesign_checkbox_option_id() {
		return design_checkbox_option_id;
	}

	public void setDesign_checkbox_option_id(String design_checkbox_option_id) {
		this.design_checkbox_option_id = design_checkbox_option_id;
	}

	public CheckboxAnswerCount() {
		super();
	}

	public CheckboxAnswerCount(String checkbox_answer_count_id, Integer checkbox_answer_count,
			String design_checkbox_option_id) {
		super();
		this.checkbox_answer_count_id = checkbox_answer_count_id;
		this.checkbox_answer_count = checkbox_answer_count;
		this.design_checkbox_option_id = design_checkbox_option_id;
	}

	@Override
	public String toString() {
		return "CheckboxAnswerCount [checkbox_answer_count_id=" + checkbox_answer_count_id + ", checkbox_answer_count="
				+ checkbox_answer_count + ", design_checkbox_option_id=" + design_checkbox_option_id + "]";
	}

}
