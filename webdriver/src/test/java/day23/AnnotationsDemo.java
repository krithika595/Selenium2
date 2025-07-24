package day23;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*
 1)Login -- @BeforeMethod
 2)search --@Test
 3)adv search ---@Test
 4)Logout ---@AfterClass
 */

import org.testng.annotations.Test;

public class AnnotationsDemo {
  @BeforeClass
  void login() {
	  System.out.println("This is login...");
  }
  @Test(priority=1)
  void search() {
	  System.out.println("This is search...");
  }
  @Test(priority=2)
  void advancedsearch() {
	  System.out.println("Advanced search ...");
  }
  @AfterClass()
  void logout() {
	  System.out.println("This is logout...");
  }
}
