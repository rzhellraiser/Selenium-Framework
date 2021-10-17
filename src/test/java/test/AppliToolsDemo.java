package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

/**
 * 
 * @author RENZO
 * 1. What's visual validation -> Avtivity to validate the UI appears correctly to the user (Location, Size, Shape, Color, Pixel, Fonts)
 * 2. What is Applitools
 * 3. How to use Applitools with Selenium scripts
 * 4. How to accept/reject/ignore changes in UI
 */

public class AppliToolsDemo {

	static String projectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Initialize the eyes SDK and set your private key
		Eyes eyes = new Eyes();
		eyes.setApiKey("UjwV2trezIoQ1e1115H3O40Ye47kr8IMZjf5e40RBgzAU110");
		
		try {
			//Start the test and set the browser's viewport size to 
			eyes.open(driver, "Hello World!", "My first Selenium Java test",
				new RectangleSize(800,600));
			
			//Navigate the browser to the "Hello World!" website
			//driver.get("https://applitools.com/helloworld");
			driver.get("https://applitools.com/helloworld/?diff2");
			
			//Visual checkpoint #1
			eyes.checkWindow("Hello!");
			
			//Click the 'Click me!' button
			driver.findElement(By.tagName("button")).click();
			
			//Visual checkpoint #2
			eyes.checkWindow("Click!");
			
			//End the test
			eyes.close();
		} finally {
			//Close the browser
			driver.quit();
			
			//If the test was aborted before eyes.close was called, 
			eyes.abortIfNotClosed();
		}
	}
}
