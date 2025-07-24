package day11;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignment {
/* 1) Handle country dropdown with/without using Select class:
 * https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states
 * a)count total number of options
 * b)print all options
 * c)select one option
 * 
 * 3)https://testautomationpractice.blogspot.com/
 * colors mult select box
 * */
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states");
		driver.manage().window().maximize();
		
		/*List<WebElement> options=driver.findElements(By.xpath("//select[@id='country-list']//option"));
		System.out.println(options.size());
		for(WebElement op:options) {
			System.out.println(op);
		}
		for(WebElement op:options) {
			String text=op.getText();
			if(text.equals("India")) {
				op.click();
			}
		}*/
		
		WebElement drpcountrylist=driver.findElement(By.xpath("//select[@id='country-list']"));
		Select drpcountry=new Select(drpcountrylist);
		drpcountry.selectByIndex(1);
		drpcountry.selectByValue("5");
		drpcountry.selectByVisibleText("India");
		
		
		List<WebElement> drps=drpcountry.getOptions();
		System.out.println(drps.size());
		for(WebElement drp:drps) {
			System.out.println(drp.getText());
		}
		

	}

}
