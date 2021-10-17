package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OracleHomePage {
	
	private static WebElement element = null;
	
	public static WebElement icon_search(WebDriver driver) {
		element = driver.findElement(By.id("u28search"));
		return element;
	}
	
	public static WebElement textbox_search(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='askoracleinput']"));
		return element;
	}
	
	public static WebElement link_ProductsMenu(WebDriver driver) {
		element = driver.findElement(By.linkText("Products"));
		return element;
	}
	
	public static WebElement link_ProductsItem(WebDriver driver) {
		element = driver.findElement(By.partialLinkText("universi"));
		return element;
	}
	
	

}
