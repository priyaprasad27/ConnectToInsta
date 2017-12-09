package com.designevolution.finalproject.connectToInsta.domain.api;

import java.util.List;

public class Data {

	String id;
	User user;
	Images images;
	String created_time;
	Caption caption;
	boolean user_has_liked;
	Likes likes;
	List<String> tags;
	String filter;
	Comments comments;
	String type;
	String link;
	String location;
	String attribution;
	List<User> users_in_photo;
	List<CarouselMedia> carousel_media;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Images getImages() {
		return images;
	}
	public void setImages(Images images) {
		this.images = images;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public Caption getCaption() {
		return caption;
	}
	public void setCaption(Caption caption) {
		this.caption = caption;
	}
	public boolean isUser_has_liked() {
		return user_has_liked;
	}
	public void setUser_has_liked(boolean user_has_liked) {
		this.user_has_liked = user_has_liked;
	}
	public Likes getLikes() {
		return likes;
	}
	public void setLikes(Likes likes) {
		this.likes = likes;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public Comments getComments() {
		return comments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAttribution() {
		return attribution;
	}
	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
	public List<User> getUsers_in_photo() {
		return users_in_photo;
	}
	public void setUsers_in_photo(List<User> users_in_photo) {
		this.users_in_photo = users_in_photo;
	}
	public List<CarouselMedia> getCarousel_media() {
		return carousel_media;
	}
	public void setCarousel_media(List<CarouselMedia> carousel_media) {
		this.carousel_media = carousel_media;
	}
	
}
