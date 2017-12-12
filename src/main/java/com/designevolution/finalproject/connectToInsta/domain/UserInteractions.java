package com.designevolution.finalproject.connectToInsta.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserInteractions {

	public void prompt(String prompt) {
		System.out.println(prompt);
	}

	public void readUserAccessToken() throws IOException {
    	FileReader reader = new FileReader(ConnectToInstaConstants.DESKTOP + ConnectToInstaConstants.ACCESS_TOKEN_FILE);
		BufferedReader bufferReader = new BufferedReader(reader);
		String line = "";
		
		while((line = bufferReader.readLine())!= null){
			ConnectToInstaConstants.ACCESS_TOKEN = line;	
		}
		
		bufferReader.close();
		
	}

	@SuppressWarnings("resource")
	public String getUserData(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.next();
        return inputValue;
    }
}
