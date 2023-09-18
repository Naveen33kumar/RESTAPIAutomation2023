package com.api.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.base.TestBase;
import com.api.client.RestClient;

public class GetAPItest extends TestBase{

	TestBase testBase;
	RestClient restClient;
	String serviceURL;
	String apiURL;
	String URL;
	
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException
	{
		testBase = new TestBase();
		serviceURL = prop.getProperty("url");
		apiURL = prop.getProperty("serviceurl");
		
		URL = serviceURL + apiURL;
		
	}
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException
	{
		restClient = new RestClient();
		restClient.get(URL);
	}	
}