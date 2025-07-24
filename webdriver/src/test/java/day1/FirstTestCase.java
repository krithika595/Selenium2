package day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

/*
 Test case
 ---------
 1) Launch browser(chrome)
 2) open URL https://demo.opencart.com/
 3) Validate title should be "Your Store"
  4) close browser
  
 */

public class FirstTestCase  {

	public static void main(String[] args) {
		// 1) Launch browser(chrome)
		//ChromeDriver driver=new ChromeDriver();
		//WebDriver driver=new ChromeDriver();
		WebDriver driver=new EdgeDriver();
		
		//2) open URL https://demo.opencart.com/
		driver.get("https://www.facebook.com/");
		
		//3) Validate title should be "Your Store"
		String act_title=driver.getTitle();
		if(act_title.equals("Facebook – log in or sign up")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		System.out.println(act_title);
		
		//4) close browser
		driver.close();
		//driver.quit();

	}

}
