package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccountPage extends BasePage{

	public RegisterAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastName;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement txtconfirmpwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkagree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement comfmsg;
	
	public void setFirstName(String firstName) {
		txtfirstName.sendKeys(firstName);
	}
	public void setLastName(String lastName) {
		txtlastName.sendKeys(lastName);
	}
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txttelephone.sendKeys(telephone);
	}
	public void setPwd(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void setCmfPwd(String cmpwd) {
		txtconfirmpwd.sendKeys(cmpwd);
	}
	public void selectAgree() {
		chkagree.click();
	}
	public void clickContinue() {
		btncontinue.click();
	}
	public String getConfMsg() {
		return (comfmsg.getText());
	}
}
