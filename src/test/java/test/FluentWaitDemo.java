package test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

/**
 * 
 * @author RENZO 
 * Fluent Wait is a class in Selenium API 
 * - When we want apply it to a specific element 
 * - Set max wait time period - set polling frequency 
 * - set to ignore specific exceptions
 */

public class FluentWaitDemo {

	static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("abcd" + Keys.ENTER);
		//driver.findElement(By.linkText("ABCD & Company - Connecting Organizations to Stakeholders"));

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 2 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.linkText("ChuChu TV Classics - ABCD Song in Alphabet Water Park ..."));
				
				if(linkElement.isEnabled()) {
					System.out.println("Element found");
				}
				return linkElement;
			}
		});
		
		element.click();

		Thread.sleep(3000);

		driver.close();
		driver.quit();
	}
}
