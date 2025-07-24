package day6;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetMethods {
	// we can access these methods through webdriver instance 
	// related to web page
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		
		//get(url) - opens the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		//getTitle() - returns title of the page
		System.out.println(driver.getTitle());
		
		//getCurrentUrl() - returns URL of the page
		System.out.println(driver.getCurrentUrl());
		
		//getPageSource() - returns source code of the page
		//System.out.println(driver.getPageSource());
		
		//getWindowHandle() - returns ID of the single Browser window
		//System.out.println("WindowID:"+driver.getWindowHandle());
		
		//getWindowHandles() - returns ID's of the multiple browser windows
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //this will open new browser window
		
		Set<String> windowids=driver.getWindowHandles();
		System.out.println(windowids);
		
		

	}

}
