package day23;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/*
 Hard Assertions
 ----------------
 we can access from "Assert" class
 methods are static
 * if hard assertion failed then rest of the statements will not be executed.
 
 soft assertion
 ------------------
 we can access through "SoftAssert" object
 
 SoftAssert sa=new SoftAssert();
 sa.assertTrue()
 
 if soft assertion got failed then rest of the statements still execute.
 */
public class HardVSSoft {
	//@Test
	void test_hardassertions() {
		System.out.println("testing....");
		System.out.println("testing....");
		
		Assert.assertEquals(1, 2);//hard assertion
		
		System.out.println("testing...");
		System.out.println("testing...");
	}
	@Test
	void test_softassertion() {
		System.out.println("testing....");
		System.out.println("testing....");
		
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(1, 2);//soft assertion
		
		System.out.println("testing...");
		System.out.println("testing...");
		
		sa.assertAll(); //mandatory
	}
}
