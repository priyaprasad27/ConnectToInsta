package com.designevolution.finalproject.connectToInsta.domain.api;

public class Caption {

	String id;
	String text;
	String created_time;
	User from;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	
}
