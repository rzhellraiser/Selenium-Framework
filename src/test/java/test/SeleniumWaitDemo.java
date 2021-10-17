package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author RENZO
 * 1. Implicit wait: Used to define a time until when webdriver should wait before throwing an exception
 * - Implicit wait is applicable for the entire session of browser
 * 2. Explicit waits: Can be set for specific elements, for a specific condition (Ex: wait until element is clickable)
 */

public class SeleniumWaitDemo {
	
	static String projectPath = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		seleniumWaits();
	}
	
	public static void seleniumWaits() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 250 ms is the default implicit wait time
		
		driver.get("https://www.oracle.com/index.html");
		driver.findElement(By.id("u28search")).click();
		driver.findElement(By.xpath("//input[@id='askoracleinput']")).sendKeys("Oracle");
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
		
		driver.findElement(By.partialLinkText("abcd"));
		
		driver.close();
		//driver.quit();
	}

}
