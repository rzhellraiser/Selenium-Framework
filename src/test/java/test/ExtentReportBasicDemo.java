package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasicDemo {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extendReports.html");
		
		//create ExtentReports and attach reporter(s) 
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Oracle Search Test One", "this is a test to validate oracle search functionality");
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO,  "Starting test case");
		driver.get("https://www.oracle.com/index.html");
		test1.pass("Navigated to Oracle");
		
		driver.findElement(By.id("u28search")).click();
		test1.pass("Click on search icon");
		
		driver.findElement(By.xpath("//input[@id='askoracleinput']")).sendKeys("Oracle");
		test1.pass("Entered text in searchbox");
	
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		
		test1.info("Test completed");
		
		//calling flush writes everything to the log file
		extent.flush();
	}
}
   