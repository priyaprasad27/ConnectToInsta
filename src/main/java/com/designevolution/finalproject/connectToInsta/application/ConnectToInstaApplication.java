package com.designevolution.finalproject.connectToInsta.application;

import java.io.IOException;

import com.designevolution.finalproject.connectToInsta.domain.ConnectToInstaConstants;
import com.designevolution.finalproject.connectToInsta.domain.ConnectToInstaImageProcessor;
import com.designevolution.finalproject.connectToInsta.domain.ConnectToInstaInstagramResponseRetriever;
import com.designevolution.finalproject.connectToInsta.domain.UserInteractions;
import com.designevolution.finalproject.connectToInsta.domain.api.InstagramResponse;

public class ConnectToInstaApplication {
	
	public static void main(String[] args) {
		UserInteractions userInteractions = new UserInteractions();
		userInteractions.prompt("Welcome to Connect to Insta!");
		userInteractions.getUserData("Before beginning, please make sure you have your Access token stored on your desktop, and named " 
				+ ConnectToInstaConstants.ACCESS_TOKEN_FILE + ". When you have this, hit any key to continue.");
		
		try {
			userInteractions.readUserAccessToken();
			userInteractions.prompt("Great, now let's get started!");

			for (int i = 0; i < 3; i++) {
				String tag = userInteractions.getUserData("What tag would you like to store pictures from: ");
				processTag(tag, i);
			}
		} catch (IOException e) {
			userInteractions.prompt("There was an error processing your request. Please try again later.");
			e.printStackTrace();
		}
		
		userInteractions.prompt("Thank you! Your images have been saved to your desktop.");

	}

	private static void processTag(String tag, int i) throws IOException {
		ConnectToInstaInstagramResponseRetriever retriever = new ConnectToInstaInstagramResponseRetriever();
		String jsonResponse = retriever.getJsonResponse(tag);		
		retriever.storeJsonResponse(jsonResponse, i);
		InstagramResponse instagramResponse = retriever.parseJson(jsonResponse);
		
		ConnectToInstaImageProcessor imageProcessor = new ConnectToInstaImageProcessor();
		String imageToStore = imageProcessor.getURLForMostLikedImage(instagramResponse.getData());
		imageProcessor.storeImage(imageToStore, i);
	}
	
}
