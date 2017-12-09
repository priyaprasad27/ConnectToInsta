package com.designevolution.finalproject.connectToInsta.domain;

import java.util.List;

import com.designevolution.finalproject.connectToInsta.domain.api.Data;

public class ConnectToInstaImageProcessor {

	public void storeImage(String imageToStore, int i) {
		// TODO Auto-generated method stub
		
	}

	public String getURLForMostLikedImage(List<Data> dataList) {
		int highestCount = 0;
		String url = "";
		for (Data data: dataList) {
			int count = data.getLikes().getCount();
			if (count > highestCount) {
				highestCount = count;
				url = data.getImages().getStandard_resolution().getUrl();
			}
		}
		
		return url;
	}

}
