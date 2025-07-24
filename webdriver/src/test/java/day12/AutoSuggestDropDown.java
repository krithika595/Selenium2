package day12;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoSuggestDropDown {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
		
		List<WebElement> lists=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		System.out.println(lists.size());
		
		for(WebElement list:lists) {
			if(list.getText().equals("selenium dev")) {
				list.click();
				break;
			}
		}

	}

}
