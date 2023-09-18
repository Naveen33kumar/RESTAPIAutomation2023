package com.api.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	//1.GET method
	public void get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);// http get request
		CloseableHttpResponse closeaableHttpResponse = httpClient.execute(httpget); // hit the GET URL
		
		//a.status code
		int statusCode = closeaableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("status code " + statusCode);
		
		//b.JSON string
		String responseString = EntityUtils.toString(closeaableHttpResponse.getEntity(),"UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("response JSON from API " + responseJson);
		
		//c. All Headers
		Header[] headersArray = closeaableHttpResponse.getAllHeaders();
		
		HashMap<String, String> allHeaders = new HashMap<>();
		
		for(Header header : headersArray)
		{
			allHeaders.put(header.getName(), header.getValue());
		}
		
		System.out.println("Headers array " + allHeaders);
	}
}