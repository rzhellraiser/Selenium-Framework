package testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author RENZO
 * 1. How to re-run failed tests manually (by running testng-failed.xml file generated in "test-output" folder for failed tests)
 * 2. How to re-run failed tests automated (https://testng.org/doc/documentation-main.html#rerunning)
 * 3. How to retry tests just after failure (Use of RetryAnalyzer and bind it to a test)
 */

public class TestNGRetryTestDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("I am inside Test 2");
		//int i = 1/0;
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void test3() {
		System.out.println("I am inside Test 3");
		Assert.assertTrue(0>1);
	}

}
