package day11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElements(By.xpath("//select[@id='colors']"));
		List<WebElement> options=driver.findElements(By.xpath("//select[@id='colors']//option"));
		System.out.println(options.size());
		for(WebElement option:options) {
			System.out.println(option.getText());
		}
		driver.findElement(By.xpath("//select[@id='colors']//option[1]")).click();
		for(WebElement option:options) {
			String text=option.getText();
			if(text.equals("Blue")){
				option.click();
			}
		}
		

	}

}
