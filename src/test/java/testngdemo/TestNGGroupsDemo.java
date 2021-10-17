package testngdemo;

import org.testng.annotations.Test;

/**
 * 
 * @author RENZO
 * 1. How to create test groups 
 * - How to run tests from groups
 * - How to include / exclude groups
 * 2. How to create metagroups (custom groups to include/exclude other groups)
 * 3. How to use regular expression
 * 4. How to define groups at class level
 */

@Test(groups = {"AllClassTests"}) //Groups at class level
public class TestNGGroupsDemo {
	
	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("This is test 1");
	}
	
	//@Test(groups = {"sanity", "smoke"})
	@Test(groups = {"windows.regression"})  //to be used with regular expressions
	public void test2() {
		System.out.println("This is test 2");
	}

	//@Test(groups = {"sanity", "regression"})
	@Test(groups = {"linux.regression"}) //to be used with regular expressions
	public void test3() {
		System.out.println("This is test 3");
	}
	
	@Test
	public void test4() {
		System.out.println("This is test 4");
	}
}
