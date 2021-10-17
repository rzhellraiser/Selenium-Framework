package test;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * 
 * @author RENZO
 * 1. What is saucelabs -> Cloud based test platform for web and mobile apps
 * 2. Create an account in Saucelabs
 * 3. Run selenium tests on saucelabs 
 */

public class SauceLabsDemo {

	//Get this info from Saucelabs profile account details
	public static final String USERNAME = "rzhellraiser";
	public static final String ACCESS_KEY = "xxxxxxx";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	//static String projectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities().chrome();
		//caps.setCapability("platform", "Windows 10");
		caps.setCapability("platform", "Linux");
		caps.setCapability("version", "latest");
		caps.setCapability("name", "GoogleTest1");
		caps.setCapability("extendedDebugging", "true");
		caps.setCapability("buildNumber", "3.0");
		
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		//System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("q")).sendKeys("automation" + Keys.ENTER);
		System.out.println(driver.getTitle());
		
		driver.close();
		driver.quit();
		System.out.println("Test completed");
	}
}
