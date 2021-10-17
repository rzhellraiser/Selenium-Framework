package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import pages.OracleSearchPageObjects;

public class TestNGWithProperties {

	WebDriver driver = null;
	public static String browserName = null;
	
	@BeforeTest
	public void setUpTest() { 
		String projectPath = System.getProperty("user.dir");
		//Get the properties value for browser
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	
	@Test
	public void oracleSearchTest() {
		OracleSearchPageObjects searchPageObj = new OracleSearchPageObjects(driver);
		driver.get("https://www.oracle.com/index.html");
		//click on the search icon
		searchPageObj.clickIconSearch();
		//enter text on the search field
		searchPageObj.setTextInSearchBox("Oracle");
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		//driver.quit();
		System.out.println("Test completed successfully!");
		PropertiesFile.setProperties();
	}
}
