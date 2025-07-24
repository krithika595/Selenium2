package day9;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		
		List<WebElement> checkboxes=driver.findElements(By.xpath("//div[@id='HTML8']//div[@class='widget-content']//tbody//input"));
		for(int  i=0; i<checkboxes.size();i++) {
			if(i==0||i==4) {
				continue;
			}
			checkboxes.get(i).click();
		}
		
		for(WebElement checkbox:checkboxes) {
			if(checkbox.isSelected()) {
				checkbox.click();
			}
		}
		
		List<WebElement> radios=driver.findElements(By.xpath("//div[@class='form-group']/parent::*/child::div[3]//input[@type='radio']"));
		
		for(WebElement radio:radios) {
			radio.click();
		}
		
		driver.get("https://mypage.rediff.com/login/dologin");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.switchTo().alert().accept();
		
	}

}
