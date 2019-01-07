package com.wjy.bean.swagger;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class SwaggerBean {

	@ApiModelProperty(value = "Swagger - ID", example = "1", hidden = false)
	private Integer swaggerId;

	@ApiModelProperty(value = "Swagger - NAME", example = "swagger", hidden = false)
	private String swaggerName;

	@ApiModelProperty(value = "Swagger - DATE", example = "2019-01-07", hidden = false)
	private Date swaggerDate;

	@ApiModelProperty(value = "Swagger - DESC", hidden = true)
	private String swaggerDesc;

	public Integer getSwaggerId() {
		return swaggerId;
	}

	public void setSwaggerId(Integer swaggerId) {
		this.swaggerId = swaggerId;
	}

	public String getSwaggerName() {
		return swaggerName;
	}

	public void setSwaggerName(String swaggerName) {
		this.swaggerName = swaggerName;
	}

	public Date getSwaggerDate() {
		return swaggerDate;
	}

	public void setSwaggerDate(Date swaggerDate) {
		this.swaggerDate = swaggerDate;
	}

	public String getSwaggerDesc() {
		return swaggerDesc;
	}

	public void setSwaggerDesc(String swaggerDesc) {
		this.swaggerDesc = swaggerDesc;
	}

	@Override
	public String toString() {
		return "SwaggerBean [swaggerId=" + swaggerId + ", swaggerName=" + swaggerName + ", swaggerDate=" + swaggerDate
				+ ", swaggerDesc=" + swaggerDesc + "]";
	}

}
