package com.wjy.vo;

public class DesignCheckboxOption {

	private String design_checkbox_option_id;
	private String design_checkbox_id;
	private Integer design_checkbox_order;
	private String design_checkbox_option_content;

	public String getDesign_checkbox_option_id() {
		return design_checkbox_option_id;
	}

	public void setDesign_checkbox_option_id(String design_checkbox_option_id) {
		this.design_checkbox_option_id = design_checkbox_option_id;
	}

	public String getDesign_checkbox_id() {
		return design_checkbox_id;
	}

	public void setDesign_checkbox_id(String design_checkbox_id) {
		this.design_checkbox_id = design_checkbox_id;
	}

	public Integer getDesign_checkbox_order() {
		return design_checkbox_order;
	}

	public void setDesign_checkbox_order(Integer design_checkbox_order) {
		this.design_checkbox_order = design_checkbox_order;
	}

	public String getDesign_checkbox_option_content() {
		return design_checkbox_option_content;
	}

	public void setDesign_checkbox_option_content(String design_checkbox_option_content) {
		this.design_checkbox_option_content = design_checkbox_option_content;
	}

	public DesignCheckboxOption() {
		super();
	}

	public DesignCheckboxOption(String design_checkbox_option_id, String design_checkbox_id,
			Integer design_checkbox_order, String design_checkbox_option_content) {
		super();
		this.design_checkbox_option_id = design_checkbox_option_id;
		this.design_checkbox_id = design_checkbox_id;
		this.design_checkbox_order = design_checkbox_order;
		this.design_checkbox_option_content = design_checkbox_option_content;
	}

	@Override
	public String toString() {
		return "DesignCheckboxOption [design_checkbox_option_id=" + design_checkbox_option_id + ", design_checkbox_id="
				+ design_checkbox_id + ", design_checkbox_order=" + design_checkbox_order
				+ ", design_checkbox_option_content=" + design_checkbox_option_content + "]";
	}

}
