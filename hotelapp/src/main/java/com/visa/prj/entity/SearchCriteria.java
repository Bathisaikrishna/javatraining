package com.visa.prj.entity;

import org.springframework.stereotype.Component;

@Component
public class SearchCriteria {

	private String searchString;

	private int pageSize;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
}
