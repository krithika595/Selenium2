package Day17;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement inputbox=driver.findElement(By.xpath("//input[@id='name']"));
		
		//passing the text into inputbox-alternate of sendKeys()
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//JavascriptExecutor js= driver;
		js.executeScript("arguments[0].setAttribute('value','John')", inputbox);
		
		//clicking on element - alternative of click()
		WebElement radiobutton=driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radiobutton);
	}

}
