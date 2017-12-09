package com.designevolution.finalproject.connectToInsta.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.designevolution.finalproject.connectToInsta.domain.ConnectToInstaConstants;
import com.designevolution.finalproject.connectToInsta.domain.InstagramJSONParser;
import com.designevolution.finalproject.connectToInsta.domain.api.Data;
import com.designevolution.finalproject.connectToInsta.domain.api.InstagramResponse;

public class ConnectToInstaLauncher {
	
	public static void main(String[] args) throws IOException {
		prompt("Welcome to Connect to Insta!");
		prompt("Before beginning, please make sure you have your Access token stored on your desktop, and named " 
				+ ConnectToInstaConstants.ACCESS_TOKEN_FILE + ". When you have this, hit any key to continue.");
		
		readAccessToken();
		prompt("Great, now let's get started!");
		
		String tag1 = getUserData("What tag would you like to store pictures from: ");
		processPicture(tag1);

	}

	private static void processPicture(String tag) throws IOException {
		String jsonResponse = getJsonResponse(tag);		
		storeJsonResponse(jsonResponse);
		InstagramResponse instagramResponse = parseJson(jsonResponse);
		String imageToStore = getURLForMostLikedImage(instagramResponse.getData());
		storeImage(imageToStore);
	}

	private static void storeImage(String imageToStore) {
		// TODO Auto-generated method stub
		
	}

	private static String getURLForMostLikedImage(List<Data> dataList) {
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

	private static InstagramResponse parseJson(String jsonResponse) {
		InstagramJSONParser parser = new InstagramJSONParser();
		return parser.parseResponse(jsonResponse);
	}

	private static void storeJsonResponse(String jsonResponse) throws IOException {
		FileWriter writer = new FileWriter(ConnectToInstaConstants.JSON_RESPONSE); 
		writer.write(jsonResponse);
		writer.close();
	}

	private static String getJsonResponse(String tag) throws MalformedURLException, IOException {
		URL url = new URL(buildURI(tag));
		Scanner scanner = new Scanner(url.openStream());
		String jsonResponse = scanner.nextLine();
		scanner.close();
		return jsonResponse;
	}

	private static String buildURI(String tag) {
		return ConnectToInstaConstants.INSTAGRAM_URI + ConnectToInstaConstants.TAG + tag + ConnectToInstaConstants.RECENT_MEDIA + ConnectToInstaConstants.QUERY_PARAM_ACCESS_TOKEN + ConnectToInstaConstants.ACCESS_TOKEN;
	}

	private static void prompt(String prompt) {
		System.out.println(prompt);
	}

    private static void readAccessToken() throws IOException {
    	FileReader reader = new FileReader(ConnectToInstaConstants.DESKTOP + ConnectToInstaConstants.ACCESS_TOKEN_FILE);
		BufferedReader bufferReader = new BufferedReader(reader);
		String line = "";
		
		while((line = bufferReader.readLine())!= null){
			ConnectToInstaConstants.ACCESS_TOKEN = line;	
		}
		
		bufferReader.close();
		
	}

	@SuppressWarnings("resource")
    private static String getUserData(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.next();
        return inputValue;
    }
}
