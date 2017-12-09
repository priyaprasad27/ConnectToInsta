package com.designevolution.finalproject.connectToInsta.domain.api;

import java.util.List;

public class InstagramResponse {

	Pagination pagination;
	List<Data> data;
	Meta meta;
	
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
}
