package day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class Assigment1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		String act_titile=driver.getTitle();
		if(act_titile.equals("nopCommerce demo store. Home page title")) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
		System.out.println(act_titile);
		driver.close();
	}

}
