package day23;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	@BeforeSuite
	void bs() {
		System.out.println("This is before suite...");
	}
	@AfterSuite
	void as() {
		System.out.println("This is AfterSuite....");
	}
	@BeforeTest
	void bt() {
		System.out.println("This is before test method...");
	}
	@AfterTest
	void at() {
		System.out.println("This is after test method...");
	}
	@BeforeClass
	void bc() {
		System.out.println("This is before class method...");
	}
	@AfterClass
	void ac() {
		System.out.println("This is after class method...");
	}
	@BeforeMethod
	void bm() {
		System.out.println("This is before method...");
	}
	@AfterMethod
	void am() {
		System.out.println("This is after method...");
	}
	@Test(priority=1)
	void tm1() {
		System.out.println("This is test method1....");
	}
	@Test(priority=2)
	void tm2() {
		System.out.println("This is test method2");
	}
}
