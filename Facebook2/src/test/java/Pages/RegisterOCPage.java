package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtil;

public class RegisterOCPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public RegisterOCPage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public void openRegisterForm(String firstname,String lastname,String mail,String phone,String pass) {
		WebElement MyAccountBtn=elementUtil.getElement("oc.myaccount");
		MyAccountBtn.click();
		
		WebElement registerLink=elementUtil.getElement("oc.register");
		registerLink.click();
		
		WebElement firstName=elementUtil.getElement("oc.firstName");
		firstName.sendKeys(firstname);
		
		WebElement lastName=elementUtil.getElement("oc.lastName");
		lastName.sendKeys(lastname);
		
		WebElement email=elementUtil.getElement("oc.email");
		email.sendKeys(mail);
		
		WebElement telephone=elementUtil.getElement("oc.telephone");
		telephone.sendKeys(phone);
		
		WebElement password=elementUtil.getElement("oc.password");
		password.sendKeys(pass);
		
		WebElement confirm=elementUtil.getElement("oc.confirm");
		confirm.sendKeys(pass);
		
		WebElement agree=elementUtil.getElement("oc.agree");
		agree.click();
		
		WebElement submit=elementUtil.getElement("oc.submit");
		agree.submit();
	}

}
