package day23;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/*
 1)Login -- @BeforeMethod
 2)search --@Test
 3)Logout -- @AfterMethod
 4)Login
 5)Advanced search -- @Test
 6)Logout
 */

import org.testng.annotations.Test;

public class AnnotationsDemo2 {
  @BeforeMethod
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
  @AfterMethod
  void logout() {
	  System.out.println("This is logout...");
  }
}
