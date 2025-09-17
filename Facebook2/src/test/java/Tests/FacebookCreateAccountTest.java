package Tests;

import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.FacebookCreateAccountPage;
import utils.ScreenshotUtil;

public class FacebookCreateAccountTest extends BaseTest {

    @Test
    public void createAccountTest() {
        navigateToBaseUrl();

        FacebookCreateAccountPage createPage = new FacebookCreateAccountPage(driver);

        // Step 1: open form
        createPage.openCreateAccountForm();

        // Step 2: fill in account details
        createPage.createAccount(
                "John", 
                "Doe", 
                "johndoe123@testmail.com", 
                "Password@123", 
                "15", 
                "May", 
                "1995", 
                "Male"
        );

        // Screenshot
        ScreenshotUtil.capture(driver, "CreateAccountTest");
    }
}
