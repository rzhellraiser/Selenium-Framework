package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

/**
 * 
 * @author RENZO
 * 1. Create a new package and new class
 * 2. Implement ITestListener interface
 * 3. Add unimplemented methods of ITestListener interface
 * 4. Create a  Demo class and provide annotation 
 * 5. Run and validate
 */

public class TestNGListenerDemo2 {

	@Test
	public void test4() {
		System.out.println("I am inside Test 1");
	}
	
	@Test
	public void test5() {
		System.out.println("I am inside Test 2");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test6() {
		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped");
	}
}
