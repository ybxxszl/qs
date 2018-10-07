package com.wjy.vo;

public class DesignText {

	private String design_text_id;
	private String design_text_content;

	public String getDesign_text_id() {
		return design_text_id;
	}

	public void setDesign_text_id(String design_text_id) {
		this.design_text_id = design_text_id;
	}

	public String getDesign_text_content() {
		return design_text_content;
	}

	public void setDesign_text_content(String design_text_content) {
		this.design_text_content = design_text_content;
	}

	public DesignText() {
		super();
	}

	public DesignText(String design_text_id, String design_text_content) {
		super();
		this.design_text_id = design_text_id;
		this.design_text_content = design_text_content;
	}

	@Override
	public String toString() {
		return "DesignText [design_text_id=" + design_text_id + ", design_text_content=" + design_text_content + "]";
	}

}
