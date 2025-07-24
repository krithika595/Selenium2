package day23;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAnnotations {
	@Test
	void test() {
		//Assert.assertEquals("xyz", "xyz");//pass
		//Assert.assertEquals(123, 1234);//fail
		
		//Assert.assertEquals("abc", 123);//fail
		//Assert.assertEquals("123", 123);//fail
		
		//Assert.assertNotEquals(123, 123);//fail
		//Assert.assertNotEquals(123, 145);//pass
		
		//Assert.assertTrue(true);//pass
		//Assert.assertTrue(false);//fail
		//Assert.assertTrue(1==2);//fail
		//Assert.assertTrue(1==1);//pass
		
		//Assert.assertFalse(1==2);//Pass
		//Assert.assertFalse(1==1);//Fail
		
		//Assert.fail();
	}
}
