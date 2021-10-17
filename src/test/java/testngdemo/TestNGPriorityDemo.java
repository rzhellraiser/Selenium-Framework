package testngdemo;

import org.testng.annotations.Test;

/**
 * 
 * @author RENZO
 * 1. When tests have the same priority, it takes precedence by the alphabethic order
 * 2. When there is no method name associated to a test, it takes precedence.
 */

public class TestNGPriorityDemo {
	
	@Test
	public void one() {
		System.out.println("I am inside test1");
	}
	
	@Test(priority = 1)
	public void two() {
		System.out.println("I am inside test2");
	}
	
	@Test(priority = 1)
	public void three() {
		System.out.println("I am inside test3");
	}

}
