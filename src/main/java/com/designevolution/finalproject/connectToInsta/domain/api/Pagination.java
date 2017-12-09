package com.designevolution.finalproject.connectToInsta.domain.api;

public class Pagination {
	
	String next_min_id;
	String min_tag_id;
	String deprecation_warning;
	
	public String getNext_min_id() {
		return next_min_id;
	}
	public void setNext_min_id(String next_min_id) {
		this.next_min_id = next_min_id;
	}
	public String getMin_tag_id() {
		return min_tag_id;
	}
	public void setMin_tag_id(String min_tag_id) {
		this.min_tag_id = min_tag_id;
	}
	public String getDeprecation_warning() {
		return deprecation_warning;
	}
	public void setDeprecation_warning(String deprecation_warning) {
		this.deprecation_warning = deprecation_warning;
	}

}
