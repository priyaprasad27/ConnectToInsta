package com.designevolution.finalproject.connectToInsta.application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class TestImageDownload {

	public static void main(String[] args) throws Exception {
		String imageUrl = "https://scontent.cdninstagram.com/t51.2885-15/s320x320/e35/24126481_1448181961916567_964528828661628928_n.jpg";
		String destinationFile = "C:\\Users\\Swetha\\Desktop\\image.jpg";

		saveImage(imageUrl, destinationFile);
	}

	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

}
