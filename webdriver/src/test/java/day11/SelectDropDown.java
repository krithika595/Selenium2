package day11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement drpCountryElement=driver.findElement(By.xpath("//select[@id='country']"));
		
		Select drpCountry=new Select(drpCountryElement);
		
		//select option from the drop down
		
		//drpCountry.selectByVisibleText("France");
		//drpCountry.selectByValue("japan");
		//drpCountry.selectByIndex(2);
		
		//capture the options from the dropdown
		List<WebElement> options=drpCountry.getOptions();
		System.out.println(options.size());
		
		//printing the options
		/*for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}*/
		
		for(WebElement option:options) {
			System.out.println(option.getText());
		}

	}

}
