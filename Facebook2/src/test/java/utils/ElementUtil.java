package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String locatorKey) {
        String locatorValue = PropertyUtil.getLocator(locatorKey);
        if (locatorValue == null) {
            throw new RuntimeException("Locator not found in locator.properties: " + locatorKey);
        }
        System.out.println("Locator value: " + PropertyUtil.getLocator("create.openForm"));

        String[] parts = locatorValue.split(":", 2);
        String locatorType = parts[0].toLowerCase();
        String locatorData = parts[1];

        switch (locatorType) {
            case "id":
                return driver.findElement(By.id(locatorData));
            case "name":
                return driver.findElement(By.name(locatorData));
            case "xpath":
                return driver.findElement(By.xpath(locatorData));
            case "css":
                return driver.findElement(By.cssSelector(locatorData));
            case "classname":
                return driver.findElement(By.className(locatorData));
            case "linktext":
                return driver.findElement(By.linkText(locatorData));
            default:
                throw new RuntimeException("Unsupported locator type: " + locatorType);
        }
    }
}
