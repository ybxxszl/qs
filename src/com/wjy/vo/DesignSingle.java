package com.wjy.vo;

public class DesignSingle {

	private String design_single_id;
	private String design_single_content;

	public String getDesign_single_id() {
		return design_single_id;
	}

	public void setDesign_single_id(String design_single_id) {
		this.design_single_id = design_single_id;
	}

	public String getDesign_single_content() {
		return design_single_content;
	}

	public void setDesign_single_content(String design_single_content) {
		this.design_single_content = design_single_content;
	}

	public DesignSingle() {
		super();
	}

	public DesignSingle(String design_single_id, String design_single_content) {
		super();
		this.design_single_id = design_single_id;
		this.design_single_content = design_single_content;
	}

	@Override
	public String toString() {
		return "DesignSingle [design_single_id=" + design_single_id + ", design_single_content=" + design_single_content
				+ "]";
	}
}
