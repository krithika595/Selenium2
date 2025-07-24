package day24;

import org.testng.annotations.Test;

public class PaymentTests {
	@Test(priority=1,groups= {"sanity","regression","functional"})
	void paymentInRupees() {
		System.out.println("payment in rupees...");
	}
	
	@Test(priority=2,groups= {"sanity","regression","functional"})
	void paymentInDollars() {
		System.out.println("payment in Dollars...");
	}
}
