package com.designevolution.finalproject.connectToInsta.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.designevolution.finalproject.connectToInsta.domain.api.InstagramResponse;

public class ConnectToInstaInstagramResponseRetriever {

	public InstagramResponse parseJson(String jsonResponse) {
		InstagramJSONParser parser = new InstagramJSONParser();
		return parser.parseResponse(jsonResponse);
	}

	public void storeJsonResponse(String jsonResponse, int i) throws IOException {
		FileWriter writer = new FileWriter(ConnectToInstaConstants.JSON_RESPONSE_LOCATION + i + ConnectToInstaConstants.JSON_RESPONSE); 
		writer.write(jsonResponse);
		writer.close();
	}

	public String getJsonResponse(String tag) throws MalformedURLException, IOException {
		URL url = new URL(buildURI(tag));
		Scanner scanner = new Scanner(url.openStream());
		String jsonResponse = scanner.nextLine();
		scanner.close();
		return jsonResponse;
	}
	
	private String buildURI(String tag) {
		return ConnectToInstaConstants.INSTAGRAM_URI + ConnectToInstaConstants.TAG + tag + ConnectToInstaConstants.RECENT_MEDIA + ConnectToInstaConstants.QUERY_PARAM_ACCESS_TOKEN + ConnectToInstaConstants.ACCESS_TOKEN;
	}
}
