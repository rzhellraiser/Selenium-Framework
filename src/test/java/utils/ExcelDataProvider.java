package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

/**
 * 
 * @author RENZO
 * How to create Excel Data Provider function
 * 1. Create a new class ExcelDataProvider
 * 2. Create a function and create object for ExcelUtils
 * 3. Get row and column count
 * 4. Run a loop to get all data in an Object array
 */

public class ExcelDataProvider {
	
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() { 
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	/**
	 * 1. Create a function and provide TestNG annotation: @DataProvider(name = "<testname>")
	 * 2. Call the excel data provider function  with excel and sheet name
	 * 3. Return the data object
	 */
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "/excel/data.xlsx";
		
		Object data[][] = testData(excelPath, "test-data");
		return data;
	}
	
	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i = 1; i < rowCount; i++) {
			for(int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.println(cellData + " | ");
				data[i-1][j] = cellData;
			}
			System.out.println();
		}
		return data;
	}
	
	
	/**
	 * How to get test data from excel
	 * 1. Create a function and provide TestNG annotation
	 * 2. In the function arguments, get input parameters equal to the parameters in the excel file.   
	 * 3. Use the values in your test           
	 * 4. Run a sample data driven selenium test                         
	 */
	@Test(dataProvider = "test1data")
	public void test1(String uname, String pass) throws InterruptedException {
		System.out.println(uname + " | " + pass);
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() { 
		driver.close();
		driver.quit();
	}

}
