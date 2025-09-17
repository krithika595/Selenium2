package Base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.ConfigReader;


public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log = LogManager.getLogger(this.getClass());

    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser) {
        log.info("Launching browser: " + browser);
        driver = DriverFactory.initDriver(browser);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getInt("explicitWait")));
    }

    @AfterClass
    public void teardown() {
        DriverFactory.quitDriver();
        log.info("Browser closed.");
    }

    public void navigateToBaseUrl() {
        String url = ConfigReader.get("baseUrl");
        driver.get(url);
        log.info("Navigated to URL: " + url);
    }

    
    public WebDriver getDriver() {
        return driver;
    }
}