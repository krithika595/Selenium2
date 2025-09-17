package Tests;

import Base.BaseTest;
import Pages.FacebookLoginPage;
import utils.ScreenshotUtil;
import org.testng.annotations.Test;

public class FacebookLoginTest extends BaseTest {

    @Test
    public void loginTest() {
        // open base url (from config.properties)
        navigateToBaseUrl();

        // create page object
        FacebookLoginPage loginPage = new FacebookLoginPage(driver);

        // perform login with valid creds
        loginPage.login("testuser@example.com", "password123");

        // take screenshot after login attempt
        ScreenshotUtil.capture(driver, "LoginTest");
    }
}
