package com.designevolution.finalproject.connectToInsta.domain.api;

public class User {

	String id;
	String full_name;
	String profile_picture;
	String username;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getProfile_picture() {
		return profile_picture;
	}
	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
