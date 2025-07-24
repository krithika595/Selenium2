package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test
	public void login() {
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmailAddress("ghjh@gmail.com");
			lp.setPassword("test@123");
			lp.clickLogin();
			
			MyAccountPage maccp=new MyAccountPage(driver);
			Assert.assertTrue(maccp.isMyAccountPageDisplayed());
		} catch (Exception e) {
			Assert.fail();
		}
		
	}
}
