package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	private static WebDriver driver = null;
	
	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("extend.html");
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void  test1() throws Exception {
		ExtentTest test = extent.createTest("Oracle Search Test One", "this is a test to validate oracle search functionality");
		driver.get("https://www.oracle.com/index.html");
		test.pass("Navigated to Oracle.com");  
		
		test.log(Status.INFO,  "Starting test case");
		test.info("This step shows usage of info (details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("1.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@Test
	public void  test2() throws Exception {
		ExtentTest test = extent.createTest("Oracle Search Test Two", "this is a test to validate oracle search functionality");
		test.log(Status.INFO,  "Starting test case");
		test.info("This step shows usage of info (details)");
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("1.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed successfully!");
	}
	
	@AfterSuite
	public void tearDown() {
		//calling flush writes everything to the log file
		extent.flush();
	}
}
