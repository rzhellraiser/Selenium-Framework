package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OracleSearchPageObjects {
	
	WebDriver driver = null;
	
	By ic_search = By.id("u28search");
	By textbox_search = By.xpath("//input[@id='askoracleinput']");
	
	public OracleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickIconSearch() {
		driver.findElement(ic_search).click();
	}
	
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
}
