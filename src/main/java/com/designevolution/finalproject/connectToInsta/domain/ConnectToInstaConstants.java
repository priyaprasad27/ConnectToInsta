package com.designevolution.finalproject.connectToInsta.domain;

public class ConnectToInstaConstants {
	
	public static String ACCESS_TOKEN = "";
	public static final String DESKTOP = System.getProperty("user.home") + "\\Desktop\\";
	public static final String ACCESS_TOKEN_FILE = "AccessToken.txt";
	public static final String DESKTOP_ACCESS_TOKEN_FILE = DESKTOP + ACCESS_TOKEN_FILE;
	
	public static final String JSON_RESPONSE_LOCATION = "src/main/resources/jsonResponse/";
	public static final String JSON_RESPONSE = "JSONResult.json";

	//CLIENT DATA
	public static final String REDIRECT_URI="https://priyagraj.wixsite.com/website";
	public static final String CLIENT_ID = "618bcb92b0cb46ad8fdd25529b4f266a";
	
	//URI
	public static final String INSTAGRAM_URI = "https://api.instagram.com/v1/";
	public static final String TAG = "tags/";
	public static final String RECENT_MEDIA = "/media/recent";
	public static final String QUERY_PARAM_ACCESS_TOKEN = "?access_token=";
	
}
