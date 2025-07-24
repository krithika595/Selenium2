package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	@Test
	public void testAccRegist() {
		logger.info("***** TC001 started ****");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		RegisterAccountPage rap=new RegisterAccountPage(driver);
		rap.setFirstName(randomString().toUpperCase());
		rap.setLastName(randomString().toUpperCase());
		rap.setEmail(randomString()+"@gmail.com");
		rap.setTelephone(randomNumber());
		String pwd=randomAlphaNum();
		rap.setPwd(pwd);
		rap.setCmfPwd(pwd);
		rap.selectAgree();
		rap.clickContinue();
		
		String msg=rap.getConfMsg();
		try {
			Assert.assertEquals(msg, "Your Account Has Been Created!");
		} catch (Exception e) {
			
			e.printStackTrace();
			Assert.fail();
		}
		logger.info("***** TC001 ended****");

	}
}
