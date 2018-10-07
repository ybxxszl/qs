package com.wjy.vo;

public class DesignSingleOption {

	private String design_single_option_id;
	private String design_single_id;
	private Integer design_single_order;
	private String design_single_option_content;

	public String getDesign_single_option_id() {
		return design_single_option_id;
	}

	public void setDesign_single_option_id(String design_single_option_id) {
		this.design_single_option_id = design_single_option_id;
	}

	public String getDesign_single_id() {
		return design_single_id;
	}

	public void setDesign_single_id(String design_single_id) {
		this.design_single_id = design_single_id;
	}

	public Integer getDesign_single_order() {
		return design_single_order;
	}

	public void setDesign_single_order(Integer design_single_order) {
		this.design_single_order = design_single_order;
	}

	public String getDesign_single_option_content() {
		return design_single_option_content;
	}

	public void setDesign_single_option_content(String design_single_option_content) {
		this.design_single_option_content = design_single_option_content;
	}

	public DesignSingleOption() {
		super();
	}

	public DesignSingleOption(String design_single_option_id, String design_single_id, Integer design_single_order,
			String design_single_option_content) {
		super();
		this.design_single_option_id = design_single_option_id;
		this.design_single_id = design_single_id;
		this.design_single_order = design_single_order;
		this.design_single_option_content = design_single_option_content;
	}

	@Override
	public String toString() {
		return "DesignSingleOption [design_single_option_id=" + design_single_option_id + ", design_single_id="
				+ design_single_id + ", design_single_order=" + design_single_order + ", design_single_option_content="
				+ design_single_option_content + "]";
	}

}
