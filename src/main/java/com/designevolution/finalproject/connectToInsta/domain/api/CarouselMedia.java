package com.designevolution.finalproject.connectToInsta.domain.api;

import java.util.List;

public class CarouselMedia {

	Images images;
	List<User> users_in_photo;
	String type;
	public Images getImages() {
		return images;
	}
	public void setImages(Images images) {
		this.images = images;
	}
	public List<User> getUsers_in_photo() {
		return users_in_photo;
	}
	public void setUsers_in_photo(List<User> users_in_photos) {
		this.users_in_photo = users_in_photos;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
