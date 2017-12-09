package com.designevolution.finalproject.connectToInsta.application;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ConnectToInstaLauncher {
	
	private static String REDIRECT_URI="https://linarespamela.wixsite.com/designandevolution";
	private static String CLIENT_ID = "c04a229bfe1348ab87f3ff509acdc2a3";
	private static String TOKEN = "token";
	private static String CODE = "code";
	private static String SCOPE = "likes+public_content ";
	private static String URI_AUTHENTICATE ="/oauth/authorize/?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&response_type=" + CODE + "&scope="+ SCOPE;
	private static String URI_ACCESSTOKEN ="/oauth/authorize/?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&response_type=" + TOKEN ;
	private static String ACCESS_TOKEN;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Connect to Insta!");
		String userName = getUserData("Please enter your username: ");
        String password = getUserData("Please enter your password: ");

        authenticateUser(userName, password);

	}

    public static String authenticateUser(String userName, String password) throws IOException {
        String jsonResponse = null;

        HttpHost target = new HttpHost("instagram.com", 443, "https");
        CredentialsProvider credsProvider = buildCredentials(userName, password, target);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();

        try {
            HttpClientContext localContext = createClientContext(target);
            HttpGet httpget = new HttpGet(URI_ACCESSTOKEN);
            executeGetHttpRequest(target, httpclient, localContext, httpget);
        }
        catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        finally {
            httpclient.close();
        }
        
        return jsonResponse;
    }
    

    private static HttpClientContext createClientContext(HttpHost target) {
        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();

        // Generate BASIC scheme object and add it to the local
        // auth cache        
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);

        // Add AuthCache to the execution context
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);

        return localContext;
    }
    
    private static void executeGetHttpRequest(HttpHost target, CloseableHttpClient httpclient, HttpClientContext localContext, HttpGet httpget) throws IOException, ClientProtocolException {
        System.out.println("Executing request " + httpget.getRequestLine()
                + " to target " + target);
        for (int i = 0; i < 3; i++) {
            CloseableHttpResponse response = httpclient.execute(target, httpget,
                    localContext);
            if (response.getStatusLine().getStatusCode() == 200) {
            	Header locationHeader = response.getFirstHeader("Location");
            	String location = locationHeader.getValue();
            	String[] splitLocation = location.split("=");
            	ACCESS_TOKEN = splitLocation[1];
                break;
            } else {
                System.out.println("Error no re-direct::::" + response.getStatusLine());
            }
        }

    }
    
    private static CredentialsProvider buildCredentials(String userName, String password, HttpHost target) {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(userName, password));

        return credsProvider;	
    }

	@SuppressWarnings("resource")
    private static String getUserData(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.next();
        return inputValue;
    }
}
