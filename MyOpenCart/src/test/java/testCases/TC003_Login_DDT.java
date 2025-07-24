package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_Login_DDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_Login_DDT(String email,String pwd,String exp) {
		try {
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmailAddress(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			MyAccountPage maccp=new MyAccountPage(driver);
			boolean targetpage=maccp.isMyAccountPageDisplayed();
			
			if(exp.equalsIgnoreCase("valid")) {
				if(targetpage==true) {
					Assert.assertTrue(true);
					maccp.clickLogout();
				}else {
					Assert.assertTrue(false);
				}
			}else {
				if(targetpage==true) {
					Assert.assertTrue(false);
					maccp.clickLogout();
				}else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
