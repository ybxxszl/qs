package com.wjy.bean.custom;

public class QueryBean<T> {

	private Integer pageCurrent; // 当前页码
	private Integer pageSize; // 每页条数
	private Integer pageTotal; // 总页数
	private Integer itemBegin; // 起始条索引
	private Integer itemEnd; // 结束条索引
	private Integer itemTotal; // 总条数
	private String searchContent; // 搜索内容
	private T searchVO; // 搜索实体

	// 默认分页的每页条数
	public Integer getPageSizeORDefault() {
		if (getPageSize() == null) {
			setPageSize(10);
		}
		return getPageSize();
	}

	// 计算总页数
	public Integer getCalculatePageTotal() {
		int total = getItemTotal() / getPageSize();
		if (getItemTotal() % getPageSize() != 0) {
			total++;
		}
		return total;
	}

	// 计算起始条索引
	public Integer getCalculateItemBegin() {
		return (getPageCurrent() - 1) * getPageSize();
	}

	// 计算结束条索引
	public Integer getCalculateItemEnd() {
		return getPageCurrent() * getPageSize() > getItemTotal() ? getItemTotal() : getPageCurrent() * getPageSize();
	}

	public Integer getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getItemBegin() {
		return itemBegin;
	}

	public void setItemBegin(Integer itemBegin) {
		this.itemBegin = itemBegin;
	}

	public Integer getItemEnd() {
		return itemEnd;
	}

	public void setItemEnd(Integer itemEnd) {
		this.itemEnd = itemEnd;
	}

	public Integer getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(Integer itemTotal) {
		this.itemTotal = itemTotal;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public T getSearchVO() {
		return searchVO;
	}

	public void setSearchVO(T searchVO) {
		this.searchVO = searchVO;
	}

	public QueryBean() {
		super();
	}

	public QueryBean(Integer pageCurrent, Integer pageSize, T searchVO) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.searchVO = searchVO;
	}

	public QueryBean(Integer pageCurrent, Integer pageSize, String searchContent, T searchVO) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.searchContent = searchContent;
		this.searchVO = searchVO;
	}

	public QueryBean(Integer pageCurrent, Integer pageSize, Integer pageTotal, Integer itemBegin, Integer itemEnd,
			Integer itemTotal, String searchContent, T searchVO) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.pageTotal = pageTotal;
		this.itemBegin = itemBegin;
		this.itemEnd = itemEnd;
		this.itemTotal = itemTotal;
		this.searchContent = searchContent;
		this.searchVO = searchVO;
	}

	@Override
	public String toString() {
		return "QueryBean [pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", pageTotal=" + pageTotal
				+ ", itemBegin=" + itemBegin + ", itemEnd=" + itemEnd + ", itemTotal=" + itemTotal + ", searchContent="
				+ searchContent + ", searchVO=" + searchVO + "]";
	}

}
