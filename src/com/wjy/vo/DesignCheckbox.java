package com.wjy.vo;

public class DesignCheckbox {

	private String design_checkbox_id;
	private String design_checkbox_content;

	public String getDesign_checkbox_id() {
		return design_checkbox_id;
	}

	public void setDesign_checkbox_id(String design_checkbox_id) {
		this.design_checkbox_id = design_checkbox_id;
	}

	public String getDesign_checkbox_content() {
		return design_checkbox_content;
	}

	public void setDesign_checkbox_content(String design_checkbox_content) {
		this.design_checkbox_content = design_checkbox_content;
	}

	public DesignCheckbox() {
		super();
	}

	public DesignCheckbox(String design_checkbox_id, String design_checkbox_content) {
		super();
		this.design_checkbox_id = design_checkbox_id;
		this.design_checkbox_content = design_checkbox_content;
	}

	@Override
	public String toString() {
		return "DesignCheckbox [design_checkbox_id=" + design_checkbox_id + ", design_checkbox_content="
				+ design_checkbox_content + "]";
	}

}
