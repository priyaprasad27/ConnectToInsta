package com.designevolution.finalproject.connectToInsta.domain.api;

public class Images {

	Image thumbnail;
	Image low_resolution;
	Image standard_resolution;
	
	public Image getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Image getLow_resolution() {
		return low_resolution;
	}
	public void setLow_resolution(Image low_resolution) {
		this.low_resolution = low_resolution;
	}
	public Image getStandard_resolution() {
		return standard_resolution;
	}
	public void setStandard_resolution(Image standard_resolution) {
		this.standard_resolution = standard_resolution;
	}
	
}
