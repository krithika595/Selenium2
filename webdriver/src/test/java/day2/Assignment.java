package day2;

import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		//name
		driver.findElement(By.name("q")).sendKeys("iphone");
		
		//id
		boolean displaystatus=driver.findElement(By.id("customerCurrency")).isDisplayed();
		System.out.println(displaystatus);
		
		//linktext
		//driver.findElement(By.linkText("Register")).click();
		//driver.findElement(By.partialLinkText("Electro")).click();
		
		//className
		List<WebElement> links=driver.findElements(By.className("sublist-toggle"));
		System.out.println(links.size());
		
		//tagName
		List<WebElement> images=driver.findElements(By.tagName("img"));
		System.out.println(images.size());

	}

}
