package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * 
 * @author RENZO
 * 1. What are headless browsers -> Web browsers without a head or GUI (program runs at backend)
 * 2. Why should we use headless browsers 
 * -> Running your tests on a headless systems like linux or without GUI.
 * -> When you want to simulate multiple browser behavior on a single machine.
 * 3. when should we NOT use headless browsers
 * -> If you need to visually observe your test on the browser
 * -> It does not give you exact feedback of what your customers will actually experience on your website.
 * -> Sometimes may throw errors that is not observed on real browsers.
 * 4. Examples of headless browsers -> HTML Unit browser, Zombie.js, SlimerJS, trifleJS, PhantomJS
 */

public class HeadlessBrowserDemo {

	static String projectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		
		//Chrome capabilities to handle headless tests
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation" + Keys.ENTER);
		
		driver.close();
		driver.quit();
		
		System.out.println("Completed");
	}
}
