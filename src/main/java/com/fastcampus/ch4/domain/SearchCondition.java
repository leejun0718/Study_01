package com.fastcampus.ch4.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
	private Integer page =1;
	private Integer pageSize =10;
//	private Integer offset = 0;
	private String keyword = "";
	private String option = "";
	
	
	
	 public String getQueryString(Integer page) {
			return UriComponentsBuilder.newInstance()
			       .queryParam("page", page)
			       .queryParam("pageSize", getPageSize())
			       .queryParam("option", getOption())
			       .queryParam("keyword", getKeyword())
			       .build().toString();
			       
		 }
public String getQueryString() {
//	return UriComponentsBuilder.newInstance()
//	       .queryParam("page",sc.getPage())
//	       .queryParam("pageSize", sc.getPageSize())
//	       .queryParam("option", sc.getOption())
//	       .queryParam("keyword", sc.getKeyword())
//	       .build().toString();
	 return getQueryString(page);
	       
}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getOffset() {
		return (page-1) * pageSize;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public SearchCondition(Integer page, Integer pageSize, String keyword, String option) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.keyword = keyword;
		this.option = option;
	}
	public SearchCondition() {
	}
	@Override
	public String toString() {
		return "SearchCondition [page=" + page + ", pageSize=" + pageSize + ", offset=" + getOffset() + ", keyword="
				+ keyword + ", option=" + option + "]";
	}
	
	
}
