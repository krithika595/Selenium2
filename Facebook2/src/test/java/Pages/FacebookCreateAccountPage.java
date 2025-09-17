package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtil;

public class FacebookCreateAccountPage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public FacebookCreateAccountPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }
    
    public void openCreateAccountForm() {
        WebElement createAccountBtn = elementUtil.getElement("create.openForm");
        createAccountBtn.click();
    }

    public void createAccount(String firstName, String lastName, String email, String password,
                              String birthDay, String birthMonth, String birthYear, String gender) {

        elementUtil.getElement("create.firstname").sendKeys(firstName);
        elementUtil.getElement("create.lastname").sendKeys(lastName);
        elementUtil.getElement("create.email").sendKeys(email);
        elementUtil.getElement("create.password").sendKeys(password);

        elementUtil.getElement("create.day").sendKeys(birthDay);
        elementUtil.getElement("create.month").sendKeys(birthMonth);
        elementUtil.getElement("create.year").sendKeys(birthYear);

        switch (gender.toLowerCase()) {
            case "male":
                elementUtil.getElement("create.genderMale").click();
                break;
            case "female":
                elementUtil.getElement("create.genderFemale").click();
                break;
            case "custom":
                elementUtil.getElement("create.genderCustom").click();
                break;
            default:
                throw new IllegalArgumentException("Invalid gender: " + gender);
        }

        elementUtil.getElement("create.submit").click();
    }
}
