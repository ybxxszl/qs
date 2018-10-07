package com.wjy.vo;

import java.util.Date;

public class DesignTemplet {

	private String design_templet_id;
	private String design_templet_name;
	private Date finish_time;
	private Date start_recovery_time;
	private Date end_recovery_time;
	private Integer state;
	private String link;
	private String author_id;

	public String getDesign_templet_id() {
		return design_templet_id;
	}

	public void setDesign_templet_id(String design_templet_id) {
		this.design_templet_id = design_templet_id;
	}

	public String getDesign_templet_name() {
		return design_templet_name;
	}

	public void setDesign_templet_name(String design_templet_name) {
		this.design_templet_name = design_templet_name;
	}

	public Date getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(Date finish_time) {
		this.finish_time = finish_time;
	}

	public Date getStart_recovery_time() {
		return start_recovery_time;
	}

	public void setStart_recovery_time(Date start_recovery_time) {
		this.start_recovery_time = start_recovery_time;
	}

	public Date getEnd_recovery_time() {
		return end_recovery_time;
	}

	public void setEnd_recovery_time(Date end_recovery_time) {
		this.end_recovery_time = end_recovery_time;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public DesignTemplet() {
		super();
	}

	public DesignTemplet(String design_templet_id, String author_id) {
		super();
		this.design_templet_id = design_templet_id;
		this.author_id = author_id;
	}

	public DesignTemplet(String design_templet_id, String design_templet_name, Date finish_time,
			Date start_recovery_time, Date end_recovery_time, Integer state, String link, String author_id) {
		super();
		this.design_templet_id = design_templet_id;
		this.design_templet_name = design_templet_name;
		this.finish_time = finish_time;
		this.start_recovery_time = start_recovery_time;
		this.end_recovery_time = end_recovery_time;
		this.state = state;
		this.link = link;
		this.author_id = author_id;
	}

	@Override
	public String toString() {
		return "DesignTemplet [design_templet_id=" + design_templet_id + ", design_templet_name=" + design_templet_name
				+ ", finish_time=" + finish_time + ", start_recovery_time=" + start_recovery_time
				+ ", end_recovery_time=" + end_recovery_time + ", state=" + state + ", link=" + link + ", author_id="
				+ author_id + "]";
	}

}
