package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import junit.framework.Assert;

/**
 * 
 * @author RENZO
 * 1. Create a new package and new class
 * 2. Implement ITestListener interface
 * 3. Add unimplemented methods of ITestListener interface
 * 4. Create a  Demo class and provide annotation 
 * 5. Run and validate
 */

public class TestNGListenerDemo {

	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
		
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.oracle.com/index.html");
		driver.findElement(By.id("u28search123")).click();
		
		driver.close();
	}
	
	@Test
	public void test3() {
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped");
	}
}
