package testngdemo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * 
 * @author RENZO
 * 1. How to ignore tests (using @Ignore annotation)
 * 2. How to ignore all tests in a class
 * 3. How to ignore all tests inside a package --> creating a package-info java class(package with the same name for current package)
 */

//@Ignore  //At class level
public class TestNGIgnoreTestsDemo {
	
	//@Ignore  //At test method level
	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	 
	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
	}

}
