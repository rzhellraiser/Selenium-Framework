package testngdemo;

import org.testng.annotations.Test;

/**
 * 
 * @author RENZO
 * 1. How to create test dependencies
 * 2. Whats happens when tests have priority set
 * 3. How to create dependencies on multiple tests
 * 4. How to create group dependencies
 * 5. Using regular expressions
 */

public class TestNGDependencyDemo {

	//@Test(dependsOnMethods = {"test2"}, priority=1)  --> Dependency with priority
	//@Test(dependsOnMethods = {"test2", "test3"})  --> Depends on methods
	//@Test(dependsOnGroups = {"sanity1"})  --> Depends on groups
	@Test(dependsOnGroups = {"sanity.*"})  // --> Using regular expressions
	public void test1() {
		System.out.println("I am inside Test 1");
	}
	
	@Test(groups = {"sanity1"})
	public void test2() {
		System.out.println("I am inside Test 2");
	}
	
	@Test(groups = {"sanity2"})
	public void test3() {
		System.out.println("I am inside Test 3");
	}
}
