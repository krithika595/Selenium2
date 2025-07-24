package day24;

import org.testng.annotations.Test;

public class SignUpTests {
	@Test(priority=1,groups= {"regression"})
	void signupbyemail() {
		System.out.println("This is signup by email...");
	}
	
	@Test(priority=2,groups= {"regression"})
	void signupbyfacebook() {
		System.out.println("This is signup by facebook...");
	}
	
	@Test(priority=3,groups= {"regression"})
	void signupbytwitter() {
		System.out.println("This is signup by twitter...");
	}
}
