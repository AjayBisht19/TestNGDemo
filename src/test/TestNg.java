package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg {
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("Inside Before Test");
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("Inside Before Method");
	}
	
	@Test
	public void starting234() {
		System.out.println("Inside start 1");
	}
	
	@Test(groups= {"Regression"})
	public void test1() {
		System.out.println("Inside test 1");
	}
	
	@Test(groups= {"Smoke"})
	public void test2() {
		System.out.println("Inside test 2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside after method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Inside after test");
	}
	
}
