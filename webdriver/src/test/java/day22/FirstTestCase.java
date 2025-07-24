package day22;

import org.testng.annotations.Test;

/*
 1) open app
 2)Login
 3)Logout
 TestNG execute test methods based on alphabetical order.
 @Test(priority=num)controls the order of execution.
 Once you provide priority to the test methods, then order of methods is not considered.
 priorities can be random numbers(no need to have consecutive numbers)
 if you dont provide priority then default value is zero(0)
 If the priorities are same then again execute methods in alphabetical order.
 TestNG execute test methods only if they are having @Test annotations.
 */
public class FirstTestCase {
	@Test(priority=1)
	void openapp() {
		System.out.println("opening application....");
	}
	@Test(priority=2)
	void login() {
		System.out.println("Login to application....");
	}
	@Test(priority=3)
	void logout() {
		System.out.println("Logout  from application...");
	}
}
