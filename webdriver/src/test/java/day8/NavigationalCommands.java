package day8;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

public class NavigationalCommands {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver=new ChromeDriver();
		
		//diver.get() ---> accepts URL in string format only
		//driver.navigate().to() ---> accepts URL in the string format & URL object format.
		
		//URL url=new URL("https://demo.nopcommerce.com/");
		//driver.navigate().to(url);
		
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh();
		
		
		
		

	}

}
