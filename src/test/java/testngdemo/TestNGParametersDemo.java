package testngdemo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 
 * @author RENZO
 * 1. How to parameterize tests
 * 2. How to run tests with parameters
 * 3. How to make parameters optional
 * 
 * NOTE: @Parameters annotation can be placed on any method that already has following annotations:
 * - @Test
 * - @Before/After
 * - @Factory
 * 
 * @Parameters annotation can also be placed class constructor 
 * In testng.xml yo can put parameters under <suite> or <test> tag. If  two params have the same name, the one
 * at <test> level takes precedence. 
 */

public class TestNGParametersDemo {
	
	@Test
	@Parameters({"MyName"})  //we need to provide a value for this required parameter (defined at testng.xml)
	public void test1(String name) {
		System.out.println("Name is: " + name);
	}
	
	@Test
	@Parameters({"MyName1"})  //When is optional parameter we can even set a null value or a default one 
	public void test2(@Optional("Rz") String name) {
		System.out.println("Name is: " + name);
	}

}
