package com.wjy.vo;

public class DesignTempletIndex {

	private String design_templet_index_id;
	private Integer design_templet_index_sign;
	private Integer design_templet_index_order;
	private String design_exercise_id;
	private String design_templet_id;

	public String getDesign_templet_index_id() {
		return design_templet_index_id;
	}

	public void setDesign_templet_index_id(String design_templet_index_id) {
		this.design_templet_index_id = design_templet_index_id;
	}

	public Integer getDesign_templet_index_sign() {
		return design_templet_index_sign;
	}

	public void setDesign_templet_index_sign(Integer design_templet_index_sign) {
		this.design_templet_index_sign = design_templet_index_sign;
	}

	public Integer getDesign_templet_index_order() {
		return design_templet_index_order;
	}

	public void setDesign_templet_index_order(Integer design_templet_index_order) {
		this.design_templet_index_order = design_templet_index_order;
	}

	public String getDesign_exercise_id() {
		return design_exercise_id;
	}

	public void setDesign_exercise_id(String design_exercise_id) {
		this.design_exercise_id = design_exercise_id;
	}

	public String getDesign_templet_id() {
		return design_templet_id;
	}

	public void setDesign_templet_id(String design_templet_id) {
		this.design_templet_id = design_templet_id;
	}

	public DesignTempletIndex() {
		super();
	}

	public DesignTempletIndex(String design_templet_index_id, Integer design_templet_index_sign,
			Integer design_templet_index_order, String design_exercise_id, String design_templet_id) {
		super();
		this.design_templet_index_id = design_templet_index_id;
		this.design_templet_index_sign = design_templet_index_sign;
		this.design_templet_index_order = design_templet_index_order;
		this.design_exercise_id = design_exercise_id;
		this.design_templet_id = design_templet_id;
	}

	@Override
	public String toString() {
		return "DesignTempletIndex [design_templet_index_id=" + design_templet_index_id + ", design_templet_index_sign="
				+ design_templet_index_sign + ", design_templet_index_order=" + design_templet_index_order
				+ ", design_exercise_id=" + design_exercise_id + ", design_templet_id=" + design_templet_id + "]";
	}

}
