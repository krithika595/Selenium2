package Tests;

import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.RegisterOCPage;

public class OCRegisterAccountTest extends BaseTest{

	@Test
	public void register() {
		navigateToBaseUrl();
		
		RegisterOCPage register=new RegisterOCPage(driver);
		register.openRegisterForm("Krithika","Yadav","abc@gmail.com","123456789","test@123");
		
	}
}
