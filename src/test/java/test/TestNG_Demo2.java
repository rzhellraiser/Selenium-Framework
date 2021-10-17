package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.OracleSearchPageObjects;

public class TestNG_Demo2 {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void oracleSearchTest2() {
		OracleSearchPageObjects searchPageObj = new OracleSearchPageObjects(driver);
		driver.get("https://www.oracle.com/index.html");
		//click on the search icon
		searchPageObj.clickIconSearch();
		//enter text on the search field
		searchPageObj.setTextInSearchBox("Oracle");
	}
	
	@Test
	public void oracleSearchTest3() {
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
		driver.quit();
		System.out.println("Test completed successfully!");
	}

}
