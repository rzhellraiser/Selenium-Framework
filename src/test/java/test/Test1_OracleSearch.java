package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.OracleHomePage;

public class Test1_OracleSearch {
	
	private static WebDriver driver;
	
	public static void main(String[] args) {
		oracleSearch();
	}
	
	public static void oracleSearch() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		//goto google.com
		driver.get("https://www.oracle.com/index.html");
		//click on the search icon
		OracleHomePage.icon_search(driver).click();
		//enter text on the search field
		OracleHomePage.textbox_search(driver).sendKeys("oracle");
		
		//close browser
		driver.close();
		
		System.out.println("Test completed successfully!");
	}

}
