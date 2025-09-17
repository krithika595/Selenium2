package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.FacebookLoginPage;
import utils.ScreenshotUtil;

public class FacebookInvalidLoginTest extends BaseTest {
    @Test
    public void invalidLoginTest() {
        navigateToBaseUrl();
        FacebookLoginPage loginPage = new FacebookLoginPage(driver);
        loginPage.login("invaliduser@example.com", "wrongpassword");
        ScreenshotUtil.capture(driver, "InvalidLoginTest");

        boolean errorDisplayed = driver.findElements(By.xpath("//div[contains(text(),'wrong')]")).size() > 0;
        Assert.assertTrue(errorDisplayed, "Error message should be displayed for invalid login");
    }
}
