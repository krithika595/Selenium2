package day16;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenLinkInNewTab {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement reglink=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		Actions act= new Actions(driver);
		
		//ctrl+reglink
		act.keyDown(Keys.CONTROL).click(reglink).keyUp(Keys.CONTROL).perform();
		
		//switching to registration page
		Set<String> allids=driver.getWindowHandles();
		List<String> ids=new ArrayList<>(allids);
		driver.switchTo().window(ids.get(1));
		
		//home page
		driver.switchTo().window(ids.get(0));
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("tshirts");

	}

}
