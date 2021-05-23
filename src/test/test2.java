package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class test2 {

	@Test
	public void test2() {
		System.out.println("Inside class test 2");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside before suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside after suite");
	}
	
}
