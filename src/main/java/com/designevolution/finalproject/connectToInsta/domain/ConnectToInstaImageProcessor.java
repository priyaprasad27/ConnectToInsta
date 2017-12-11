package com.designevolution.finalproject.connectToInsta.domain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import com.designevolution.finalproject.connectToInsta.domain.api.Data;

public class ConnectToInstaImageProcessor {


	public void storeImage(String imageUrl, int i) throws IOException {
		URL url = new URL(imageUrl);
		InputStream inputSteam = url.openStream();
		OutputStream outoutSteam = new FileOutputStream(ConnectToInstaConstants.DESKTOP + "\\ConnectToInsta\\" +i + ConnectToInstaConstants.IMAGE_JPG);
		byte[] b = new byte[2048];
		int length;

		while ((length = inputSteam.read(b)) != -1) {
			outoutSteam.write(b, 0, length);
		}

		inputSteam.close();
		outoutSteam.close();
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
