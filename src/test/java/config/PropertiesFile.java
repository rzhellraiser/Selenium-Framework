package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Properties;

import test.TestNGWithProperties;

/**
 * 
 * @author RENZO
 * How to get data from Properties file
 * 1. Create an object of Properties class
 * 2. Create an object of class InputStream
 * 3. Load properties file
 * 4. Get values from Properties file
 * 
 * How to set data to properties file
 * 1. Create an object of class Properties class
 * 2. Create an object of class OutputStream
 * 3. Set values
 * 4. Write data to a properties file
 */

public class PropertiesFile {
	
	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
	}
	
	public static void getProperties() {
		
		try {			
			InputStream input = new FileInputStream(projectPath + "/src/test/java/config/config.properties");
			prop.load(input);
			String  browser = prop.getProperty("browser");
			System.out.println(browser);
			//Assign a browser value into the test class so it can be run in a specific browser
			TestNGWithProperties.browserName =  browser;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();	
		}
	}
	
	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath + "/src/test/java/config/config.properties");
			//prop.setProperty("browser", "chrome");
			prop.setProperty("result", "pass");
			prop.store(output, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();	
		}                    
	}
}
