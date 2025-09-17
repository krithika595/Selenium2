package Pages;

import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class FacebookLoginPage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public FacebookLoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    public void login(String username, String password) {
        elementUtil.getElement("login.email").sendKeys(username);
        elementUtil.getElement("login.password").sendKeys(password);
        elementUtil.getElement("login.button").click();
    }
}
