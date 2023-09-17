package com.api.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	public Properties prop;
	
	public TestBase() {
		// TODO Auto-generated constructor stub
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\navee\\eclipse-workspace\\RestAPIAutomation\\src\\main\\java\\com\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e)
		{
			e.printStackTrace();
		}		
	}
}