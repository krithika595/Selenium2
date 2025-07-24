package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//constructor
	LoginPage(WebDriver driver){
		this.driver=driver;
	}

	//Locators
	By txt_username=By.xpath("//input[@placeholder='Username']");
	By txt_password=By.xpath("//input[@placeholder='Password']");
	By btn_login_loc=By.xpath("//button[normalize-space()='Login']");
	
	//Action methods
	
	public void setUserName(String user) {
		driver.findElement(txt_username).sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		driver.findElement(txt_password).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(btn_login_loc).click();
	}
}
