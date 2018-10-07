package com.wjy.vo;

public class TextAnswer {

	private String text_answer_id;
	private String design_text_id;
	private String text_answer_content;

	public String getText_answer_id() {
		return text_answer_id;
	}

	public void setText_answer_id(String text_answer_id) {
		this.text_answer_id = text_answer_id;
	}

	public String getDesign_text_id() {
		return design_text_id;
	}

	public void setDesign_text_id(String design_text_id) {
		this.design_text_id = design_text_id;
	}

	public String getText_answer_content() {
		return text_answer_content;
	}

	public void setText_answer_content(String text_answer_content) {
		this.text_answer_content = text_answer_content;
	}

	public TextAnswer() {
		super();
	}

	public TextAnswer(String text_answer_id, String design_text_id, String text_answer_content) {
		super();
		this.text_answer_id = text_answer_id;
		this.design_text_id = design_text_id;
		this.text_answer_content = text_answer_content;
	}

	@Override
	public String toString() {
		return "TextAnswer [text_answer_id=" + text_answer_id + ", design_text_id=" + design_text_id
				+ ", text_answer_content=" + text_answer_content + "]";
	}

}
