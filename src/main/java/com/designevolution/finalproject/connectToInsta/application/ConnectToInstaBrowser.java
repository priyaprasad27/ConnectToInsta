package com.designevolution.finalproject.connectToInsta.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.stream.JsonReader;

public class ConnectToInstaBrowser {
	

	public static void main(String[] args) throws IOException {
		String accessToken = "";
		String inputFile = "AccessToken.txt";
		//String outputFile  = "output.txt";
		String outputFile  = "result.JSON";
		String path = "C:\\Users\\Pamela\\Desktop";
		String line="";
		
		FileReader reader = new FileReader(path+"\\"+inputFile);
		BufferedReader b = new BufferedReader(reader);
		
		System.out.println(path+"\\"+inputFile);
		
		while((line = b.readLine())!= null){
			accessToken = line;	
		}
		
		b.close();
        
		String host = "https://api.instagram.com";
		String ele = "v1";
		String endPoint = "users/self";
		
		String redirect = "https://priyagraj.wixsite.com/website";
		String clientID = "618bcb92b0cb46ad8fdd25529b4f266a";
		String fullurl = host+"/"+ele+"/"+endPoint+"/?access_token="+accessToken;
		
		URL url = new URL(fullurl);
			
		Scanner s = new Scanner(url.openStream());
		String str = s.nextLine();
		//System.out.println(str);
		
				
		FileWriter writer = new FileWriter(path+"\\"+outputFile); 
		writer.write(str);
		writer.close();
	
		JsonReader jr = new JsonReader(new FileReader(path+"\\"+"result.json"));
		jr.beginObject();
		
		while(jr.hasNext()){
			
			String name = jr.nextName();
			if(name.equals("data")) {
				System.out.println(jr.nextString());
			}
	   		
		}
		jr.endObject();
		
	}

}
