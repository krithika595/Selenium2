package day16;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabaAndsWindows {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.opencart.com/");
		//selenium4.x
		//driver.switchTo().newWindow(WindowType.TAB);//opens new tab
		driver.switchTo().newWindow(WindowType.WINDOW);//opens new window
		driver.get("https://orangehrm.com/");
		driver.manage().window().maximize();

	}

}
