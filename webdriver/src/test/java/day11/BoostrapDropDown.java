package day11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoostrapDropDown {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click(); //opens dropdown
		
		//Select single option
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//capture all options and find out size
		List<WebElement> options=driver.findElements(By.xpath("ul[contains(@class,'multiselect')]//label"));
		System.out.println(options.size());
		
		//printing options
		for(WebElement option:options) {
			System.out.println(option.getText());
		}
		
		//select multiple options
		for(WebElement option:options) {
			String text=option.getText();
			if(text.equals("Java")||text.equals("Python")||text.equals("MySql")) {
				option.click();
			}			
		}
		

	}

}
